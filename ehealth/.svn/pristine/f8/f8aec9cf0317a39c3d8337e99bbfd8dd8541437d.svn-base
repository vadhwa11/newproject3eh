package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.ADMINISTRATIVE_SEX_JSP;
import static jkt.hms.util.RequestConstants.ADMISSION_TYPE_JSP;
import static jkt.hms.util.RequestConstants.CASTE_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMITTEE;
import static jkt.hms.util.RequestConstants.COMMON;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.CONTACT_NUMBER;
import static jkt.hms.util.RequestConstants.CONTACT_PERSON;
import static jkt.hms.util.RequestConstants.COUNTRY_ID;
import static jkt.hms.util.RequestConstants.COUNTRY_JSP;
import static jkt.hms.util.RequestConstants.CURRENCY_ID;
import static jkt.hms.util.RequestConstants.CURRENCY_JSP;
import static jkt.hms.util.RequestConstants.DEPARTMENT_GROUP;
import static jkt.hms.util.RequestConstants.DEPARTMENT_GROUP_PARAMETER;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.DISTRICT_ID;
import static jkt.hms.util.RequestConstants.DISTRICT_JSP;
import static jkt.hms.util.RequestConstants.DOCUMENT_JSP;
import static jkt.hms.util.RequestConstants.END_DATE;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.FROM_TIME;
import static jkt.hms.util.RequestConstants.GROUP_JSP;
import static jkt.hms.util.RequestConstants.GRP_PARA_MASTER;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.IMG_REQ;
import static jkt.hms.util.RequestConstants.JASPER_FILE_NAME;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_JSP;
import static jkt.hms.util.RequestConstants.OCCUPATION_JSP;
import static jkt.hms.util.RequestConstants.PARAMETER_MASTER;
import static jkt.hms.util.RequestConstants.PIN_CODE;
import static jkt.hms.util.RequestConstants.POSTCODE_JSP;
import static jkt.hms.util.RequestConstants.POST_CODE_ID;
import static jkt.hms.util.RequestConstants.REFERENCE_JSP;
import static jkt.hms.util.RequestConstants.RELATION_JSP;
import static jkt.hms.util.RequestConstants.RELIGION_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SPECIALTY_JSP;
import static jkt.hms.util.RequestConstants.START_DATE;
import static jkt.hms.util.RequestConstants.STATE_ID;
import static jkt.hms.util.RequestConstants.STATE_JSP;
import static jkt.hms.util.RequestConstants.TITLE_JSP;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TO_TIME;
import static jkt.hms.util.RequestConstants.UNIT_OF_MEASUREMENT_JSP;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VALUE_TYPE;
import static jkt.hms.util.RequestConstants.VILLAGE;
import static jkt.hrms.util.HrmsRequestConstants.STATUS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.HrCommitteeHeader;
import jkt.hms.masters.business.HrInstitutionalSanctionedPost;
import jkt.hms.masters.business.HrMasSanctionedPostOrder;
import jkt.hms.masters.business.MasAccountSchedule;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasAnswers;
import jkt.hms.masters.business.MasBranch;
import jkt.hms.masters.business.MasCadre;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasCharityType;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasDocument;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasLsgType;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasQuestions;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSpecialOfficial;
import jkt.hms.masters.business.MasSpecialityDeptGroup;
import jkt.hms.masters.business.MasSpecialityDeptGroupValue;
import jkt.hms.masters.business.MasSpecialityGroup;
import jkt.hms.masters.business.MasSpecialityHeading;
import jkt.hms.masters.business.MasSpecialityParameter;
import jkt.hms.masters.business.MasSpecialtyGroupParameter;
import jkt.hms.masters.business.MasSpecialtyTemplate;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStream;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.PhMasElectricalSection;
import jkt.hms.masters.business.PhMasPanchayat;
import jkt.hms.masters.business.PhMasParliyamentAssembly;
import jkt.hms.masters.business.PhMaster;
import jkt.hms.masters.business.PhMasterData;
import jkt.hms.masters.business.SpDeptGroupM;
import jkt.hms.masters.business.SpDeptGroupT;
import jkt.hms.masters.business.SpGroupParameter;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.GeneralMasterHandlerService;
import jkt.hms.opd.handler.OPDHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jxl.Cell;
import jxl.CellView;
import jxl.DateCell;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Alignment;
import jxl.write.Border;
import jxl.write.Label;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class GeneralMasterController extends MultiActionController {
	/*
	 * Logger Implemented By Mukesh Narayan Singh Date 26 Aug 2010
	 */
	static final Logger log = Logger
			.getLogger(jkt.hms.masters.controller.GeneralMasterController.class);
	GeneralMasterHandlerService generalMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	MasUnitOfMeasurement masUnitOfMeasurement = new MasUnitOfMeasurement();
	MasPatientType masPatientType = new MasPatientType();
	OPDHandlerService opdHandlerService = null;

	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String jspName = "";
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String status = "";
	int id = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;
	String userName = "";

	// -----------------------------------------Title------------------------------------------------

	public ModelAndView searchTitle(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String titleCode = null;
		String titleName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			titleCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			titleName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);

			}
			log.info(request.getParameter(SEARCH_FIELD));
			

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			titleCode = searchField;
			titleName = null;

		} else {
			titleCode = null;
			titleName = searchField;
		}
		map = generalMasterHandlerService.searchTitle(titleCode, titleName);

		jsp = TITLE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("titleCode", titleCode);
		map.put("titleName", titleName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showTitleJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = generalMasterHandlerService.showTitleJsp();

		String jsp = TITLE_JSP;
		jsp += ".jsp";
		title = "Title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTitle(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasTitle masTitle = new MasTitle();
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

		List titleCodeList = new ArrayList();
		List titleNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			titleCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			titleNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((titleCodeList.size() == 0 || titleCodeList == null)
				&& (titleNameList.size() == 0 || titleNameList == null)) {
			masTitle.setTitleCode(code);
			masTitle.setTitleName(name);
			masTitle.setStatus("Y");
			//masTitle.setLastChgBy(changedBy);
			masTitle.setLastChgDate(currentDate);
			masTitle.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addTitle(masTitle);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((titleCodeList.size() != 0 || titleCodeList != null)
				|| (titleNameList.size() != 0) || titleNameList != null) {
			if ((titleCodeList.size() != 0 || titleCodeList != null)
					&& (titleNameList.size() == 0 || titleNameList == null)) {

				message = "Title Code  already exists.";
			} else if ((titleNameList.size() != 0 || titleNameList != null)
					&& (titleCodeList.size() == 0 || titleCodeList == null)) {

				message = "Title Name already exists.";
			} else if ((titleCodeList.size() != 0 || titleCodeList != null)
					&& (titleNameList.size() != 0 || titleNameList != null)) {

				message = "Title Code and Title Name already exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showTitleJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TITLE_JSP;
		title = "Add Title";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editTitle(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String titleCode = "";
		String titleName = "";
		int titleId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			titleId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			titleCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			titleName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", titleId);
		generalMap.put("titleCode", titleCode);
		generalMap.put("name", titleName);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingTitleNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingTitleNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editTitleToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingTitleNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showTitleJsp";

		try {
			map = generalMasterHandlerService.showTitleJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TITLE_JSP;
		title = "update Title";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteTitle(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int titleId = 0;
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
			titleId = Integer.parseInt(request.getParameter(COMMON_ID));
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

		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteTitle(titleId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showTitleJsp";

		try {
			map = generalMasterHandlerService.showTitleJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TITLE_JSP;
		title = "delete Title";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------------------------------------Relation--------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showRelationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = generalMasterHandlerService.showRelationJsp();
		jsp = RELATION_JSP;
		jsp += ".jsp";
		title = "Relation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchRelation(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String relationCode = null;
		String relationName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			relationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			relationName = request.getParameter(SEARCH_NAME);
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
			relationCode = searchField;
			relationName = null;

		} else {
			relationCode = null;
			relationName = searchField;
		}
		map = generalMasterHandlerService.searchRelation(relationCode,
				relationName);
		jsp = RELATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("relationCode", relationCode);
		map.put("relationName", relationName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRelation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasRelation masRelation = new MasRelation();
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

		List relationCodeList = new ArrayList();
		List relationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			relationCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			relationNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((relationCodeList.size() == 0 || relationCodeList == null)
				&& (relationNameList.size() == 0 || relationNameList == null)) {
			masRelation.setRelationCode(code);
			masRelation.setRelationName(name);
			masRelation.setStatus("Y");
			//masRelation.setLastChgBy(changedBy);
			masRelation.setLastChgDate(currentDate);
			masRelation.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addRelation(masRelation);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((relationCodeList.size() != 0 || relationCodeList != null)
				|| (relationNameList.size() != 0) || relationNameList != null) {
			if ((relationCodeList.size() != 0 || relationCodeList != null)
					&& (relationNameList.size() == 0 || relationNameList == null)) {
				message = "Relation Code  already exists.";
			} else if ((relationNameList.size() != 0 || relationNameList != null)
					&& (relationCodeList.size() == 0 || relationCodeList == null)) {
				message = "Relation Name already exists.";
			} else if ((relationCodeList.size() != 0 || relationCodeList != null)
					&& (relationNameList.size() != 0 || relationNameList != null)) {
				message = "Relation Code and Relation Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showRelationJsp";
		try {
			map = generalMasterHandlerService.showRelationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RELATION_JSP;
		title = "Add Relation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editRelation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String relationCode = "";
		String relationName = "";
		int relationId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			relationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			relationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			relationName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("id", relationId);
		generalMap.put("relationCode", relationCode);
		generalMap.put("name", relationName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingRelationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingRelationNameList.size() == 0) {

			dataUpdated = generalMasterHandlerService
					.editRelationToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingRelationNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showRelationJsp";
		try {
			map = generalMasterHandlerService.showRelationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RELATION_JSP;
		title = "Update Relation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteRelation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int relationId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			relationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteRelation(relationId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showRelationJsp";
		try {
			map = generalMasterHandlerService.showRelationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RELATION_JSP;
		title = "Delete Relation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------------------Disposal-------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showDisposalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = (Map<String, Object>) generalMasterHandlerService
				.showDisposalJsp();
		jsp = DISPOSAL_JSP;
		jsp += ".jsp";
		title = "Disposal";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDisposal(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String disposalCode = null;
		String disposalName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			disposalCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			disposalName = request.getParameter(SEARCH_NAME);
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
			disposalCode = searchField;
			disposalName = null;

		} else {
			disposalCode = null;
			disposalName = searchField;
		}
		map = generalMasterHandlerService.searchDisposal(disposalCode,
				disposalName);

		jsp = DISPOSAL_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("disposalCode", disposalCode);
		map.put("disposalName", disposalName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDisposal(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDisposal masDisposal = new MasDisposal();
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
		List disposalCodeList = new ArrayList();
		List disposalNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			disposalCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			disposalNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((disposalCodeList.size() == 0 || disposalCodeList == null)
				&& (disposalNameList.size() == 0 || disposalNameList == null)) {
			masDisposal.setDisposalCode(code);
			masDisposal.setDisposalName(name);
			masDisposal.setStatus("y");
			masDisposal.setLastChgBy(changedBy);
			masDisposal.setLastChgDate(currentDate);
			masDisposal.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addDisposal(masDisposal);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((disposalCodeList.size() != 0 || disposalCodeList != null)
				|| (disposalNameList.size() != 0) || disposalNameList != null) {
			if ((disposalCodeList.size() != 0 || disposalCodeList != null)
					&& (disposalNameList.size() == 0 || disposalNameList == null)) {
				message = "Disposal Code  already exists.";
			} else if ((disposalNameList.size() != 0 || disposalNameList != null)
					&& (disposalCodeList.size() == 0 || disposalCodeList == null)) {
				message = "Disposal Name already exists.";
			} else if ((disposalCodeList.size() != 0 || disposalCodeList != null)
					&& (disposalNameList.size() != 0 || disposalNameList != null)) {
				message = "Disposal Code and Disposal Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showDisposalJsp";
		try {
			map = generalMasterHandlerService.showDisposalJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSAL_JSP;
		title = "Add Disposal";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDisposal(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String disposalCode = "";
		String disposalName = "";
		int disposalId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			disposalId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			disposalCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			disposalName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", disposalId);
		generalMap.put("disposalCode", disposalCode);
		generalMap.put("name", disposalName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDisposalNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingDisposalNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editDisposalToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDisposalNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showDisposalJsp";
		try {
			map = generalMasterHandlerService.showDisposalJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSAL_JSP;
		title = "update Disposal";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDisposal(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int disposalId = 0;
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
			disposalId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteDisposal(disposalId,
				generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showDisposalJsp";
		try {
			map = generalMasterHandlerService.showDisposalJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISPOSAL_JSP;
		title = "delete Disposal";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------- Marital Status
	// ----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showMaritalStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = generalMasterHandlerService.showMaritalStatusJsp();
		jsp = MARITAL_STATUS_JSP;
		jsp += ".jsp";
		title = "MaritalStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchMaritalStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String maritalStatusCode = null;
		String maritalStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			maritalStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			maritalStatusName = request.getParameter(SEARCH_NAME);
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
			maritalStatusCode = searchField;
			maritalStatusName = null;

		} else {
			maritalStatusCode = null;
			maritalStatusName = searchField;
		}

		map = generalMasterHandlerService.searchMaritalStatus(
				maritalStatusCode, maritalStatusName);

		jsp = MARITAL_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("maritalStatusCode", maritalStatusCode);
		map.put("maritalStatusName", maritalStatusName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMaritalStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
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

		List maritalStatusCodeList = new ArrayList();
		List maritalStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			maritalStatusCodeList = (List) listMap
					.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			maritalStatusNameList = (List) listMap
					.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((maritalStatusCodeList.size() == 0 || maritalStatusCodeList == null)
				&& (maritalStatusNameList.size() == 0 || maritalStatusNameList == null)) {
			masMaritalStatus.setMaritalStatusCode(code);
			masMaritalStatus.setMaritalStatusName(name);
			masMaritalStatus.setStatus("Y");
			//masMaritalStatus.setLastChgBy(changedBy);
			masMaritalStatus.setLastChgDate(currentDate);
			masMaritalStatus.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addMaritalStatus(masMaritalStatus);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((maritalStatusCodeList.size() != 0 || maritalStatusCodeList != null)
				|| (maritalStatusNameList.size() != 0)
				|| maritalStatusNameList != null) {
			if ((maritalStatusCodeList.size() != 0 || maritalStatusCodeList != null)
					&& (maritalStatusNameList.size() == 0 || maritalStatusNameList == null)) {
				message = "Marital Status Code  already exists.";
			} else if ((maritalStatusNameList.size() != 0 || maritalStatusNameList != null)
					&& (maritalStatusCodeList.size() == 0 || maritalStatusCodeList == null)) {
				message = "Marital Status Name already exists.";
			} else if ((maritalStatusCodeList.size() != 0 || maritalStatusCodeList != null)
					&& (maritalStatusNameList.size() != 0 || maritalStatusNameList != null)) {
				message = "Marital Status Code and Marital Status Name already exist.";
			}
		}

		url = "/hms/hms/generalMaster?method=showMaritalStatusJsp";
		try {
			map = generalMasterHandlerService.showMaritalStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MARITAL_STATUS_JSP;
		title = "Add Marital Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editMaritalStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String maritalStatusCode = "";
		String maritalStatusName = "";
		int maritalStatusId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			maritalStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			maritalStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			maritalStatusName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", maritalStatusId);
		generalMap.put("maritalStatusCode", maritalStatusCode);
		generalMap.put("name", maritalStatusName);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingMaritalStatusNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingMaritalStatusNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editMaritalStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingMaritalStatusNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showMaritalStatusJsp";
		try {
			map = generalMasterHandlerService.showMaritalStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MARITAL_STATUS_JSP;
		title = "Update marital Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteMaritalStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int maritalStatusId = 0;
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
			maritalStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
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

		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteMaritalStatus(
				maritalStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showMaritalStatusJsp";
		try {
			map = generalMasterHandlerService.showMaritalStatusJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MARITAL_STATUS_JSP;
		title = "Delete Marital Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------Religion--------------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showReligionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = generalMasterHandlerService.showReligionJsp();
		jsp = RELIGION_JSP;
		jsp += ".jsp";
		title = "Religion";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchReligion(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String religionCode = null;
		String religionName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			religionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			religionName = request.getParameter(SEARCH_NAME);
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
			religionCode = searchField;
			religionName = null;
		} else {
			religionCode = null;
			religionName = searchField;
		}
		map = generalMasterHandlerService.searchReligion(religionCode,
				religionName);
		jsp = RELIGION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("religionCode", religionCode);
		map.put("religionName", religionName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addReligion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasReligion masReligion = new MasReligion();
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
		List religionCodeList = new ArrayList();
		List religionNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			religionCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			religionNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((religionCodeList.size() == 0 || religionCodeList == null)
				&& (religionNameList.size() == 0 || religionNameList == null)) {
			masReligion.setReligionCode(code);
			masReligion.setReligionName(name);
			masReligion.setStatus("Y");

			Users users = new Users();
			users.setId(userId);
			masReligion.setLastChgBy(users);
			masReligion.setLastChgDate(currentDate);
			masReligion.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addReligion(masReligion);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((religionCodeList.size() != 0 || religionCodeList != null)
				|| (religionNameList.size() != 0) || religionNameList != null) {
			if ((religionCodeList.size() != 0 || religionCodeList != null)
					&& (religionNameList.size() == 0 || religionNameList == null)) {
				message = "Religion Code  already exists.";
			} else if ((religionNameList.size() != 0 || religionNameList != null)
					&& (religionCodeList.size() == 0 || religionCodeList == null)) {
				message = "Religion Name already exists.";
			} else if ((religionCodeList.size() != 0 || religionCodeList != null)
					&& (religionNameList.size() != 0 || religionNameList != null)) {
				message = "Religion Code and Religion Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showReligionJsp";
		try {
			map = generalMasterHandlerService.showReligionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RELIGION_JSP;
		title = "Add Religion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editReligion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String religionCode = "";
		String religionName = "";
		int religionId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			religionId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			religionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			religionName = request.getParameter(SEARCH_NAME);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", religionId);
		generalMap.put("religionCode", religionCode);
		generalMap.put("name", religionName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingReligionNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingReligionNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editReligionToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingReligionNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showReligionJsp";
		try {
			map = generalMasterHandlerService.showReligionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RELIGION_JSP;
		title = "update Religion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteReligion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int religionId = 0;
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
			religionId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteReligion(religionId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showReligionJsp";
		try {
			map = generalMasterHandlerService.showReligionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RELIGION_JSP;
		title = "Delete religion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------- Admission
	// Type----------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showAdmissionTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = generalMasterHandlerService.showAdmissionTypeJsp();
		jsp = ADMISSION_TYPE_JSP;
		jsp += ".jsp";
		title = "AdmissionType";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAdmissionType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String admissionTypeCode = null;
		String admissionTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			admissionTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			admissionTypeName = request.getParameter(SEARCH_NAME);
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
			admissionTypeCode = searchField;
			admissionTypeName = null;

		} else {
			admissionTypeCode = null;
			admissionTypeName = searchField;
		}

		map = generalMasterHandlerService.searchAdmissionType(
				admissionTypeCode, admissionTypeName);

		jsp = ADMISSION_TYPE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("admissionTypeCode", admissionTypeCode);
		map.put("admissionTypeName", admissionTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAdmissionType(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		MasAdmissionType masAdmissionType = new MasAdmissionType();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId = (Integer) session.getAttribute(RequestConstants.USER_ID);

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
		List admissionTypeCodeList = new ArrayList();
		List admissionTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			admissionTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			admissionTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((admissionTypeCodeList.size() == 0 || admissionTypeCodeList == null)
				&& (admissionTypeNameList.size() == 0 || admissionTypeNameList == null)) {
			masAdmissionType.setAdmissionTypeCode(code);
			masAdmissionType.setAdmissionTypeName(name);
			masAdmissionType.setStatus("Y");
			Users users = new Users();
			users.setId(userId);
			masAdmissionType.setLastChgBy(users);
			masAdmissionType.setLastChgDate(currentDate);
			masAdmissionType.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addAdmissionType(masAdmissionType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((admissionTypeCodeList.size() != 0 || admissionTypeCodeList != null)
				|| (admissionTypeNameList.size() != 0)
				|| admissionTypeNameList != null) {
			if ((admissionTypeCodeList.size() != 0 || admissionTypeCodeList != null)
					&& (admissionTypeNameList.size() == 0 || admissionTypeNameList == null)) {
				message = "Admission Type Code  already exists.";
			} else if ((admissionTypeNameList.size() != 0 || admissionTypeNameList != null)
					&& (admissionTypeCodeList.size() == 0 || admissionTypeCodeList == null)) {
				message = "Admission Type Name already exists.";
			} else if ((admissionTypeCodeList.size() != 0 || admissionTypeCodeList != null)
					&& (admissionTypeNameList.size() != 0 || admissionTypeNameList != null)) {
				message = "Admission Type Code and Admission Type Name already exist.";
			}
		}

		url = "/hms/hms/generalMaster?method=showAdmissionTypeJsp";
		try {
			map = generalMasterHandlerService.showAdmissionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ADMISSION_TYPE_JSP;
		title = "Add Admission Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAdmissionType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String admissionTypeCode = "";
		String admissionTypeName = "";
		int admissionTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		Date currentDate = null;
		String changedTime = "";
		int userId = (Integer) session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			admissionTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			admissionTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			admissionTypeName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", admissionTypeId);
		generalMap.put("admissionTypeCode", admissionTypeCode);
		generalMap.put("name", admissionTypeName);
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
		List existingAdmissionTypeNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingAdmissionTypeNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editAdmissionTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingAdmissionTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showAdmissionTypeJsp";
		try {
			map = generalMasterHandlerService.showAdmissionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ADMISSION_TYPE_JSP;
		title = "Update Admission Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAdmissionType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int admissionTypeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId = (Integer) session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			admissionTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteAdmissionType(
				admissionTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showAdmissionTypeJsp";
		try {
			map = generalMasterHandlerService.showAdmissionTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ADMISSION_TYPE_JSP;
		title = "Delete Admission Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------- Administrative
	// Sex----------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showAdministrativeSexJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = generalMasterHandlerService.showAdministrativeSexJsp();
		jsp = ADMINISTRATIVE_SEX_JSP;
		jsp += ".jsp";
		title = "AdministrativeSex";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAdministrativeSex(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String administrativeSexCode = null;
		String administrativeSexName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			administrativeSexCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			administrativeSexName = request.getParameter(SEARCH_NAME);
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
			administrativeSexCode = searchField;
			administrativeSexName = null;

		} else {
			administrativeSexCode = null;
			administrativeSexName = searchField;
		}

		map = generalMasterHandlerService.searchAdministrativeSex(
				administrativeSexCode, administrativeSexName);

		jsp = ADMINISTRATIVE_SEX_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("administrativeSexCode", administrativeSexCode);
		map.put("administrativeSexName", administrativeSexName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAdministrativeSex(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
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
			changedBy =request.getParameter(CHANGED_BY);
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
		List administrativeSexCodeList = new ArrayList();
		List administrativeSexNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			administrativeSexCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			administrativeSexNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((administrativeSexCodeList.size() == 0 || administrativeSexCodeList == null)
				&& (administrativeSexNameList.size() == 0 || administrativeSexNameList == null)) {
			masAdministrativeSex.setAdministrativeSexCode(code);
			masAdministrativeSex.setAdministrativeSexName(name);
			masAdministrativeSex.setStatus("Y");
			//masAdministrativeSex.setLastChgBy(changedBy);
			masAdministrativeSex.setLastChgDate(currentDate);
			masAdministrativeSex.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addAdministrativeSex(masAdministrativeSex);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((administrativeSexCodeList.size() != 0 || administrativeSexCodeList != null)
				|| (administrativeSexNameList.size() != 0)
				|| administrativeSexNameList != null) {
			if ((administrativeSexCodeList.size() != 0 || administrativeSexCodeList != null)
					&& (administrativeSexNameList.size() == 0 || administrativeSexNameList == null)) {
				message = "AS Code  already exists.";
			} else if ((administrativeSexNameList.size() != 0 || administrativeSexNameList != null)
					&& (administrativeSexCodeList.size() == 0 || administrativeSexCodeList == null)) {
				message = "AS Name already exists.";
			} else if ((administrativeSexCodeList.size() != 0 || administrativeSexCodeList != null)
					&& (administrativeSexNameList.size() != 0 || administrativeSexNameList != null)) {
				message = "AS Code and AS Name already exist.";
			}
		}

		url = "/hms/hms/generalMaster?method=showAdministrativeSexJsp";
		try {
			map = generalMasterHandlerService.showAdministrativeSexJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ADMINISTRATIVE_SEX_JSP;
		title = "Add Administrative Sex";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAdministrativeSex(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String administrativeSexCode = "";
		String administrativeSexName = "";
		int administrativeSexId = 0;
		String changedBy = "";
		Date changedDate = null;
		//Date currentDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			administrativeSexId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			administrativeSexCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			administrativeSexName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", administrativeSexId);
		generalMap.put("administrativeSexCode", administrativeSexCode);
		generalMap.put("name", administrativeSexName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAdministrativeSexNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingAdministrativeSexNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editAdministrativeSexToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingAdministrativeSexNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showAdministrativeSexJsp";
		try {
			map = generalMasterHandlerService.showAdministrativeSexJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ADMINISTRATIVE_SEX_JSP;
		title = "Update Administrative Sex";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAdministrativeSex(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int administrativeSexId = 0;
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
			administrativeSexId = Integer.parseInt(request
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
		dataDeleted = generalMasterHandlerService.deleteAdministrativeSex(
				administrativeSexId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showAdministrativeSexJsp";
		try {
			map = generalMasterHandlerService.showAdministrativeSexJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ADMINISTRATIVE_SEX_JSP;
		title = "Delete Administrative Sex";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Document
	// --------------------------

	public ModelAndView searchDocument(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String documentCode = null;
		String documentName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			documentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			documentName = request.getParameter(SEARCH_NAME);
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
			documentCode = searchField;
			documentName = null;

		} else {
			documentCode = null;
			documentName = searchField;
		}
		map = generalMasterHandlerService.searchDocument(documentCode,
				documentName);

		jsp = DOCUMENT_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("documentCode", documentCode);
		map.put("documentName", documentName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDocumentJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		map = generalMasterHandlerService.showDocumentJsp();

		String jsp = DOCUMENT_JSP;
		jsp += ".jsp";
		title = "Document";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDocument(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDocument masDocument = new MasDocument();

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

		List documentCodeList = new ArrayList();
		List documentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			documentCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			documentNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((documentCodeList.size() == 0 || documentCodeList == null)
				&& (documentNameList.size() == 0 || documentNameList == null)) {
			masDocument.setDocumentCode(code);
			masDocument.setDocumentName(name);
			masDocument.setStatus("Y");
			masDocument.setLastChgDate(currentDate);
			masDocument.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addDocument(masDocument);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((documentCodeList.size() != 0 || documentCodeList != null)
				|| (documentNameList.size() != 0) || documentNameList != null) {
			if ((documentCodeList.size() != 0 || documentCodeList != null)
					&& (documentNameList.size() == 0 || documentNameList == null)) {

				message = "Document Code  already exists.";
			} else if ((documentNameList.size() != 0 || documentNameList != null)
					&& (documentCodeList.size() == 0 || documentCodeList == null)) {

				message = "Document Name already exists.";
			} else if ((documentCodeList.size() != 0 || documentCodeList != null)
					&& (documentNameList.size() != 0 || documentNameList != null)) {

				message = "Document Code and Document Name already exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showDocumentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DOCUMENT_JSP;
		title = "Add Document";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDocument(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String documentCode = "";
		String documentName = "";
		int documentId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			documentId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			documentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			documentName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", documentId);
		generalMap.put("documentCode", documentCode);
		generalMap.put("name", documentName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDocumentNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingDocumentNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editDocumentToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingDocumentNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showDocumentJsp";

		try {
			map = generalMasterHandlerService.showDocumentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DOCUMENT_JSP;
		title = "update Document";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteDocument(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int documentId = 0;
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
			documentId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteDocument(documentId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showDocumentJsp";

		try {
			map = generalMasterHandlerService.showDocumentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DOCUMENT_JSP;
		title = "delete Document";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Occupation
	// --------------------------

	public ModelAndView searchOccupation(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String occupationCode = null;
		String occupationName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			occupationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			occupationName = request.getParameter(SEARCH_NAME);
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
			occupationCode = searchField;
			occupationName = null;
		} else {
			occupationCode = null;
			occupationName = searchField;
		}
		map = generalMasterHandlerService.searchOccupation(occupationCode,
				occupationName);

		jsp = OCCUPATION_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("occupationCode", occupationCode);
		map.put("occupationName", occupationName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showOccupationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = generalMasterHandlerService.showOccupationJsp();
		String jsp = OCCUPATION_JSP;
		jsp += ".jsp";
		title = "Occupation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addOccupation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasOccupation masOccupation = new MasOccupation();
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
		List occupationCodeList = new ArrayList();
		List occupationNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			occupationCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			occupationNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((occupationCodeList.size() == 0 || occupationCodeList == null)
				&& (occupationNameList.size() == 0 || occupationNameList == null)) {
			masOccupation.setOccupationCode(code);
			masOccupation.setOccupationName(name);
			masOccupation.setStatus("Y");
			//masOccupation.setLastChgBy(changedBy);
			masOccupation.setLastChgDate(currentDate);
			masOccupation.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addOccupation(masOccupation);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((occupationCodeList.size() != 0 || occupationCodeList != null)
				|| (occupationNameList.size() != 0)
				|| occupationNameList != null) {
			if ((occupationCodeList.size() != 0 || occupationCodeList != null)
					&& (occupationNameList.size() == 0 || occupationNameList == null)) {
				message = "Occupation Code  already exists.";
			} else if ((occupationNameList.size() != 0 || occupationNameList != null)
					&& (occupationCodeList.size() == 0 || occupationCodeList == null)) {
				message = "Occupation Name already exists.";
			} else if ((occupationCodeList.size() != 0 || occupationCodeList != null)
					&& (occupationNameList.size() != 0 || occupationNameList != null)) {
				message = "Occupation Code and Occupation Name already exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showOccupationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OCCUPATION_JSP;
		title = "Add Occupation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editOccupation(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String occupationCode = "";
		String occupationName = "";
		int occupationId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			occupationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			occupationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			occupationName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", occupationId);
		generalMap.put("occupationCode", occupationCode);
		generalMap.put("name", occupationName);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOccupationNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingOccupationNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editOccupationToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingOccupationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showOccupationJsp";

		try {
			map = generalMasterHandlerService.showOccupationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OCCUPATION_JSP;
		title = "update Occupation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteOccupation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int occupationId = 0;
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
			occupationId = Integer.parseInt(request.getParameter(COMMON_ID));
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

		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteOccupation(
				occupationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showOccupationJsp";

		try {
			map = generalMasterHandlerService.showOccupationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OCCUPATION_JSP;
		title = "delete Occupation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------------
	// Caste---------------------------------------

	public ModelAndView searchCaste(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String casteCode = null;
		String casteName = null;
		String searchField = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			casteCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			casteName = request.getParameter(SEARCH_NAME);
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
			casteCode = searchField;
			casteName = null;

		} else {
			casteCode = null;
			casteName = searchField;
		}
		map = generalMasterHandlerService.searchCaste(casteCode, casteName);
		jsp = CASTE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("casteCode", casteCode);
		map.put("casteName", casteName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCasteJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = generalMasterHandlerService.showCasteJsp();
		@SuppressWarnings("unused")
		ArrayList searchCasteList = (ArrayList) map.get("searchCasteList");
		jsp = CASTE_JSP;
		jsp += ".jsp";
		title = "Caste";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCaste(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasCaste masCaste = new MasCaste();

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
		List casteCodeList = new ArrayList();
		List casteNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			casteCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			casteNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((casteCodeList.size() == 0 || casteCodeList == null)
				&& (casteNameList.size() == 0 || casteNameList == null)) {
			masCaste.setCasteCode(code);
			masCaste.setCasteName(name);
			
			masCaste.setStatus("Y");
			//masCaste.setLastChgBy(changedBy);
			masCaste.setLastChgDate(currentDate);
			masCaste.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addCaste(masCaste);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((casteCodeList.size() != 0 || casteCodeList != null)
				|| (casteNameList.size() != 0) || casteNameList != null) {

			if ((casteCodeList.size() != 0 || casteCodeList != null)
					&& (casteNameList.size() == 0 || casteNameList == null)) {
				message = "Caste Code  already exists.";
			} else if ((casteNameList.size() != 0 || casteNameList != null)
					&& (casteCodeList.size() == 0 || casteCodeList == null)) {
				message = "Caste Name already exists.";
			} else if ((casteCodeList.size() != 0 || casteCodeList != null)
					&& (casteNameList.size() != 0 || casteNameList != null)) {
				message = "Caste Code and Caste Name already exist.";
			}
		}

		url = "/hms/hms/generalMaster?method=showCasteJsp";

		try {
			map = generalMasterHandlerService.showCasteJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASTE_JSP;
		title = "Add Caste";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editCaste(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String casteCode = "";
		String casteName = "";
		int casteId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			casteId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			casteCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			casteName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", casteId);
		generalMap.put("casteCode", casteCode);
		generalMap.put("name", casteName);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCasteNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCasteNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editCasteToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCasteNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showCasteJsp";

		try {
			map = generalMasterHandlerService.showCasteJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASTE_JSP;
		title = "update Caste";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteCaste(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int casteId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		Map<String, Object> generalMap = new HashMap<String, Object>();

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			casteId = Integer.parseInt(request.getParameter(COMMON_ID));
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

		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteCaste(casteId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCasteJsp";
		try {
			map = generalMasterHandlerService.showCasteJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CASTE_JSP;
		title = "delete Caste";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------- -Unit Of
	// Measurement-------------------------------------------------------

	public ModelAndView searchUnitOfMeasurement(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String unitOfMeasurementCode = null;

		String unitOfMeasurementName = null;

		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			unitOfMeasurementCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			unitOfMeasurementName = request.getParameter(SEARCH_NAME);
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
			unitOfMeasurementCode = searchField;
			unitOfMeasurementName = null;

		} else {
			unitOfMeasurementCode = null;
			unitOfMeasurementName = searchField;
		}

		map = generalMasterHandlerService.searchUnitOfMeasurement(
				unitOfMeasurementCode, unitOfMeasurementName);

		jsp = UNIT_OF_MEASUREMENT_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("unitOfMeasurementCode", unitOfMeasurementCode);
		map.put("unitOfMeasurementName", unitOfMeasurementName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUnitOfMeasurementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = generalMasterHandlerService.showUnitOfMeasurementJsp();
		jsp = UNIT_OF_MEASUREMENT_JSP;
		jsp += ".jsp";
		title = "Unit Of Measurement";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUnitOfMeasurement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasUnitOfMeasurement masUnitOfMeasurement = new MasUnitOfMeasurement();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

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

		List unitOfMeasurementCodeList = new ArrayList();
		List unitOfMeasurementNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			unitOfMeasurementCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			unitOfMeasurementNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((unitOfMeasurementCodeList.size() == 0 || unitOfMeasurementCodeList == null)
				&& (unitOfMeasurementNameList.size() == 0 || unitOfMeasurementNameList == null)) {
			masUnitOfMeasurement.setUnitOfMeasurementCode(code);
			masUnitOfMeasurement.setUnitOfMeasurementName(name);
			masUnitOfMeasurement.setStatus("y");
			Users user=new Users();
			user.setId(userId);
			masUnitOfMeasurement.setLastChgBy(user);
			masUnitOfMeasurement.setLastChgDate(currentDate);
			masUnitOfMeasurement.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addUnitOfMeasurement(masUnitOfMeasurement);

			String message = null;
			if (successfullyAdded) {
				message = "Record Added Successfully !!";

			} else {
				message = "Try Again  !!";
			}
		}

		else if ((unitOfMeasurementCodeList.size() != 0 || unitOfMeasurementCodeList != null)
				|| (unitOfMeasurementNameList.size() != 0)
				|| unitOfMeasurementNameList != null) {

			if ((unitOfMeasurementCodeList.size() != 0 || unitOfMeasurementCodeList != null)
					&& (unitOfMeasurementNameList.size() == 0 || unitOfMeasurementNameList == null)) {

				message = "UOM Code  already exists.";
			} else if ((unitOfMeasurementNameList.size() != 0 || unitOfMeasurementNameList != null)
					&& (unitOfMeasurementCodeList.size() == 0 || unitOfMeasurementCodeList == null)) {

				message = "UOM Name already exists.";
			} else if ((unitOfMeasurementCodeList.size() != 0 || unitOfMeasurementCodeList != null)
					&& (unitOfMeasurementNameList.size() != 0 || unitOfMeasurementNameList != null)) {

				message = "UOM Code and UOM already exist.";
			}

		}

		url = "/hms/hms/generalMaster?method=showUnitOfMeasurementJsp";

		try {
			map = generalMasterHandlerService.showUnitOfMeasurementJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_OF_MEASUREMENT_JSP;
		title = "Add Unit Of Measurement";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editUnitOfMeasurement(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String unitOfMeasurementCode = "";
		String unitOfMeasurementName = "";
		int unitOfMeasurementId = 0;
		int changedBy = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			unitOfMeasurementId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			unitOfMeasurementCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			unitOfMeasurementName = request.getParameter(SEARCH_NAME);
		}
		changedBy= (Integer) session.getAttribute("userId");
	/*	if (request.getParameter(CHANGED_BY) != null
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

		generalMap.put("id", unitOfMeasurementId);
		generalMap.put("unitOfMeasurementCode", unitOfMeasurementCode);
		generalMap.put("name", unitOfMeasurementName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingUnitOfMeasurementNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingUnitOfMeasurementNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editUnitOfMeasurementToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingUnitOfMeasurementNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showUnitOfMeasurementJsp";

		try {
			map = generalMasterHandlerService.showUnitOfMeasurementJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_OF_MEASUREMENT_JSP;
		title = "Update Of Measurement";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteUnitOfMeasurement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int unitOfMeasurementId = 0;
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
			unitOfMeasurementId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedBy= (Integer) session.getAttribute("userId");
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteUnitOfMeasurement(
				unitOfMeasurementId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showUnitOfMeasurementJsp";

		try {
			map = generalMasterHandlerService.showUnitOfMeasurementJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_OF_MEASUREMENT_JSP;
		title = "Delete Unit Of Measurement";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------------
	// District----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showDistrictJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showDistrict();
		String jsp = DISTRICT_JSP;
		jsp += ".jsp";
		title = "District";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDistrict(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDistrict masDistrict = new MasDistrict();
		int stateId = 0;
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

			if (!request.getParameter(STATE_ID).equals("0")) {
				stateId = Integer.parseInt(request.getParameter(STATE_ID));
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

		List districtCodeList = new ArrayList();
		List districtNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			districtCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			districtNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((districtCodeList.size() == 0 || districtCodeList == null)
				&& (districtNameList.size() == 0 || districtNameList == null)) {
			masDistrict.setDistrictCode(code);
			masDistrict.setDistrictName(name);
			if (stateId != 0) {
				MasState masState = new MasState();
				masState.setId(stateId);
				masDistrict.setState(masState);
			}
			masDistrict.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			masDistrict.setLastChgBy(users);
			masDistrict.setLastChgDate(currentDate);
			masDistrict.setLastChgTime(currentTime);
			Map<String, Object> districtMap = new HashMap<String, Object>();

			log.info("masDistrict" + masDistrict);
			districtMap.put("masDistrict", masDistrict);
			districtMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addDistrict(districtMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((districtCodeList.size() != 0 || districtCodeList != null)
				|| (districtNameList.size() != 0) || districtNameList != null) {
			if ((districtCodeList.size() != 0 || districtCodeList != null)
					&& (districtNameList.size() == 0 || districtNameList == null)) {
				message = "District Code already exists.";
			} else if ((districtNameList.size() != 0 || districtNameList != null)
					&& (districtCodeList.size() == 0 || districtCodeList == null)) {
				message = "District Name already exists.";
			} else if ((districtCodeList.size() != 0 || districtCodeList != null)
					&& (districtNameList.size() != 0 || districtNameList != null)) {
				message = "District Code and District exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showDistrict();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISTRICT_JSP;
		title = "Add District";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editDistrict(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String districtCode = "";
		String name = "";
		int stateId = 0;
		int districtId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(STATE_ID) != null
					&& !(request.getParameter(STATE_ID).equals(""))) {
				stateId = Integer.parseInt(request.getParameter(STATE_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				districtId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				districtCode = request.getParameter(CODE);
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

			generalMap.put("id", districtId);
			generalMap.put("districtCode", districtCode);
			generalMap.put("name", name);
			generalMap.put("stateId", stateId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService.editDistrict(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showDistrict();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISTRICT_JSP;
		title = "Edit District";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDistrict(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String districtCode = null;
		String districtName = null;
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
			districtCode = searchField;
			districtName = null;

		} else {
			districtCode = null;
			districtName = searchField;
		}
		map = generalMasterHandlerService.searchDistrict(districtCode,
				districtName);

		jsp = DISTRICT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("districtCode", districtCode);
		map.put("districtName", districtName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDistrict(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int districtId = 0;
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
			districtId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteDistrict(districtId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showDistrictJsp";

		try {
			map = generalMasterHandlerService.showDistrict();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DISTRICT_JSP;
		title = "delete District";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// -------------------------------- Taluk
	// ------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showTalukJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showTaluk();
		String jsp = "taluk";
		jsp += ".jsp";
		title = "Taluk";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTaluk(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasTaluk masTaluk = new MasTaluk();
		int districtId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
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

			if (request.getParameter(DISTRICT_ID) != null) {
				districtId = Integer.valueOf(request.getParameter(DISTRICT_ID));
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
			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List talukCodeList = new ArrayList();
		List talukNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			talukCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			talukNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((talukCodeList.size() == 0 || talukCodeList == null)
				&& (talukNameList.size() == 0 || talukNameList == null)) {
			masTaluk.setTalukCode(code);
			masTaluk.setTalukName(name);

			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			masTaluk.setDistrict(masDistrict);

			/*
			 * if(masDistrict.getState()!=null) { int s=
			 * masDistrict.getState().getId(); MasState state = new MasState();
			 * state.setId(s); masTaluk.setState(state); }else{ MasState state =
			 * new MasState(); state.setId(0); masTaluk.setState(state); }
			 */

			masTaluk.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			masTaluk.setLastChgBy(users);
			masTaluk.setLastChgDate(currentDate);
			masTaluk.setLastChgTime(currentTime);
			Map<String, Object> talukMap = new HashMap<String, Object>();
			talukMap.put("masTaluk", masTaluk);
			talukMap.put("hospitalId", hospitalId);
			talukMap.put("districtId", districtId);
			successfullyAdded = generalMasterHandlerService.addTaluk(talukMap);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((talukCodeList.size() != 0 || talukCodeList != null)
				|| (talukNameList.size() != 0) || talukNameList != null) {
			if ((talukCodeList.size() != 0 || talukCodeList != null)
					&& (talukNameList.size() == 0 || talukNameList == null)) {
				message = "Taluk Code already exists.";
			} else if ((talukNameList.size() != 0 || talukNameList != null)
					&& (talukCodeList.size() == 0 || talukCodeList == null)) {
				message = "Taluk Name already exists.";
			} else if ((talukCodeList.size() != 0 || talukCodeList != null)
					&& (talukNameList.size() != 0 || talukNameList != null)) {
				message = "Taluk Code and Taluk exist.";
			}
		}
		try {
			map = generalMasterHandlerService.showTaluk();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "taluk";
		title = "Add Taluk";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editTaluk(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String talukCode = "";
		String talukName = "";
		int districtId = 0;
		int talukId = 0;
		Integer userId = (Integer) session.getAttribute("userId");
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		try {
			if (request.getParameter(DISTRICT_ID) != null
					&& !(request.getParameter(DISTRICT_ID).equals(""))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				talukId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				talukCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				talukName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", talukId);
			generalMap.put("talukCode", talukCode);
			generalMap.put("name", talukName);
			generalMap.put("districtId", districtId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);
			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingTalukNameList = (List) listMap
					.get("duplicateMastersList");
			boolean dataUpdated = false;
			if (existingTalukNameList.size() == 0) {
				dataUpdated = generalMasterHandlerService.editTaluk(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingTalukNameList.size() > 0) {
				message = "Name already exists.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			map = generalMasterHandlerService.showTaluk();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "taluk";
		title = "Edit Taluk";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchTaluk(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String talukCode = null;
		String talukName = null;
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
			talukCode = searchField;
			talukName = null;

		} else {
			talukCode = null;
			talukName = searchField;
		}
		map = generalMasterHandlerService.searchTaluk(talukCode, talukName);

		jsp = "taluk";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("talukCode", talukCode);
		map.put("talukName", talukName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteTaluk(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int talukId = 0;
		String message = null;
		HttpSession session = request.getSession();
		session = request.getSession();
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
			talukId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteTaluk(talukId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showTalukJsp";
		try {
			map = generalMasterHandlerService.showTaluk();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "taluk";
		title = "delete Taluk";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPostCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showPostCodeJsp();
		String jsp = POSTCODE_JSP;
		jsp += ".jsp";
		title = "Post Code";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPostCode(HttpServletRequest request,
			HttpServletResponse response) {
		int pinCode = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		MasPostCode masPostCode = new MasPostCode();

		int districtId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();
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
			if (request.getParameter("districtId") != null) {
				districtId = Integer.parseInt(request
						.getParameter("districtId"));
			}
			if (request.getParameter(PIN_CODE) != null
					&& !request.getParameter(PIN_CODE).equals("")) {
				pinCode = Integer.parseInt(request.getParameter(PIN_CODE));
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

		List postCodeCodeList = new ArrayList();
		List postCodeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			postCodeCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			postCodeNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((postCodeCodeList.size() == 0 || postCodeCodeList == null)
				&& (postCodeNameList.size() == 0 || postCodeNameList == null)) {
			masPostCode.setPostCode(code);
			masPostCode.setPostCodeName(name);

			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			masPostCode.setDistrictId(masDistrict);

			Users users = new Users();
			users.setId(userId);
			masPostCode.setLastChgBy(users);

			// if (pinCode > 0) {
			masPostCode.setPinCode(pinCode);
			// }
			masPostCode.setStatus("Y");

			masPostCode.setLastChgDate(currentDate);
			masPostCode.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addPostCode(masPostCode);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((postCodeCodeList.size() != 0 || postCodeCodeList != null)
				|| (postCodeNameList.size() != 0) || postCodeNameList != null) {
			if ((postCodeCodeList.size() != 0 || postCodeCodeList != null)
					&& (postCodeNameList.size() == 0 || postCodeNameList == null)) {
				message = "PostCode  already exists.";
			} else if ((postCodeNameList.size() != 0 || postCodeNameList != null)
					&& (postCodeCodeList.size() == 0 || postCodeCodeList == null)) {
				message = "PostCode Name already exists.";
			} else if ((postCodeCodeList.size() != 0 || postCodeCodeList != null)
					&& (postCodeNameList.size() != 0 || postCodeNameList != null)) {
				message = "PostCode and PostCode Name exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showPostCodeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POSTCODE_JSP;
		title = "Add Post Code";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editPostCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		session = request.getSession();
		int districtId = 0;
		int postCodeId = 0;
		String changedBy = "";
		int userId = (Integer) session.getAttribute("userId");
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		int pinCode = 0;

		try {
			if (request.getParameter("districtId") != null) {
				districtId = Integer.parseInt(request
						.getParameter("districtId"));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				postCodeId = Integer.parseInt(request.getParameter(COMMON_ID));
			}

			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(PIN_CODE) != null
					&& !request.getParameter(PIN_CODE).equals("")) {
				pinCode = Integer.valueOf(request.getParameter(PIN_CODE));
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		changedDate = new Date();
		try {
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("id", postCodeId);
			generalMap.put("name", name);
			generalMap.put("pinCode", pinCode);
			generalMap.put("districtId", districtId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", currentTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService.editPostCode(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}
		try {
			map = generalMasterHandlerService.showPostCodeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POSTCODE_JSP;
		title = "Edit Post Code";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchPostCode(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String postCodeCode = null;
		String postCodeName = null;
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
			postCodeCode = searchField;
			postCodeName = null;

		} else {
			postCodeCode = null;
			postCodeName = searchField;
		}
		map = generalMasterHandlerService.searchPostCode(postCodeCode,
				postCodeName);

		jsp = POSTCODE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("postCode", postCodeCode);
		map.put("postCodeName", postCodeName);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletePostCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int postCodeId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		HttpSession session = request.getSession();
		session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			postCodeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deletePostCode(postCodeId,
				generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showPostCodeJsp";

		try {
			map = generalMasterHandlerService.showPostCodeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = POSTCODE_JSP;
		title = "Delete Post Code";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------- State -----------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showStateJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showStateJsp();
		String jsp = STATE_JSP;
		jsp += ".jsp";
		title = "State";
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addState(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasState masState = new MasState();
		HttpSession session = request.getSession();
		int majorCategoryId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Integer userId = (Integer) session.getAttribute("userId");

		try {
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}

			if (request.getParameter(COUNTRY_ID) != null) {
				majorCategoryId = Integer.valueOf(request
						.getParameter(COUNTRY_ID));
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

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List stateCodeList = new ArrayList();
		List stateNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			stateCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			stateNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((stateCodeList.size() == 0 || stateCodeList == null)
				&& (stateNameList.size() == 0 || stateNameList == null)) {
			masState.setStateCode(code);
			masState.setStateName(name);
			MasCountry masCountry = new MasCountry();
			masCountry.setId(majorCategoryId);
			masState.setCountry(masCountry);
			masState.setStatus("y");
			Users users = new Users();
			users.setId(userId);

			masState.setLastChgBy(users);
			masState.setLastChgDate(currentDate);
			masState.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addState(masState);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((stateCodeList.size() != 0 || stateCodeList != null)
				|| (stateNameList.size() != 0) || stateNameList != null) {
			if ((stateCodeList.size() != 0 || stateCodeList != null)
					&& (stateNameList.size() == 0 || stateNameList == null)) {
				message = "State Code already exists.";
			} else if ((stateNameList.size() != 0 || stateNameList != null)
					&& (stateCodeList.size() == 0 || stateCodeList == null)) {
				message = "State Name already exists.";
			} else if ((stateCodeList.size() != 0 || stateCodeList != null)
					&& (stateNameList.size() != 0 || stateNameList != null)) {
				message = "State Code and State exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showStateJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STATE_JSP;
		title = "Add State";
		jsp += ".jsp";
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editState(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String stateCode = "";
		String stateName = "";
		int countryId = 0;
		int stateId = 0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		try {
			if (request.getParameter(COUNTRY_ID) != null
					&& !(request.getParameter(COUNTRY_ID).equals(""))) {
				countryId = Integer.parseInt(request.getParameter(COUNTRY_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				stateId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				stateCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				stateName = request.getParameter(SEARCH_NAME);
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
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", stateId);
		generalMap.put("stateCode", stateCode);
		generalMap.put("name", stateName);
		generalMap.put("countryId", countryId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingStateNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingStateNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService.editState(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingStateNameList.size() > 0) {
			message = "Name already exists.";
		}
		try {
			map = generalMasterHandlerService.showStateJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STATE_JSP;
		title = "Edit State";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchState(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String stateCode = null;
		String stateName = null;
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
			stateCode = searchField;
			stateName = null;

		} else {
			stateCode = null;
			stateName = searchField;
		}
		map = generalMasterHandlerService.searchState(stateCode, stateName);
		jsp = STATE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("stateCode", stateCode);
		map.put("stateName", stateName);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteState(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int stateId = 0;
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
			stateId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteState(stateId,
				generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}

		url = "/hms/hms/generalMaster?method=showStateJsp";

		try {
			map = generalMasterHandlerService.showStateJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STATE_JSP;
		title = "delete State";
		jsp += ".jsp";
		map.put("pageNo", Integer.parseInt(request.getParameter("pageNoEdit")));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// -------------------------currency
	// ------------------------------------------------

	public ModelAndView searchCurrency(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String currencyCode = null;
		String currencyName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			currencyCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			currencyName = request.getParameter(SEARCH_NAME);
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
			currencyCode = searchField;
			currencyName = null;

		} else {
			currencyCode = null;
			currencyName = searchField;
		}
		map = generalMasterHandlerService.searchCurrency(currencyCode,
				currencyName);

		jsp = CURRENCY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("currencyCode", currencyCode);
		map.put("currencyName", currencyName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCurrencyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = generalMasterHandlerService.showCurrencyJsp();
		@SuppressWarnings("unused")
		ArrayList searchCurrencyList = (ArrayList) map
				.get("searchCurrencyList");
		jsp = CURRENCY_JSP;
		jsp += ".jsp";
		title = "Currency";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCurrency(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasCurrency masCurrency = new MasCurrency();

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
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List currencyCodeList = new ArrayList();
		List currencyNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			currencyCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			currencyNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((currencyCodeList.size() == 0 || currencyCodeList == null)
				&& (currencyNameList.size() == 0 || currencyNameList == null)) {
			masCurrency.setCurrencyCode(code);
			masCurrency.setCurrencyName(name);
			masCurrency.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			masCurrency.setLastChgBy(user);
			masCurrency.setLastChgDate(currentDate);
			masCurrency.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addCurrency(masCurrency);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((currencyCodeList.size() != 0 || currencyCodeList != null)
				|| (currencyNameList.size() != 0) || currencyNameList != null) {

			if ((currencyCodeList.size() != 0 || currencyCodeList != null)
					&& (currencyNameList.size() == 0 || currencyNameList == null)) {
				message = "Currency Code  already exists.";
			} else if ((currencyNameList.size() != 0 || currencyNameList != null)
					&& (currencyCodeList.size() == 0 || currencyCodeList == null)) {
				message = "Currency Name already exists.";
			} else if ((currencyCodeList.size() != 0 || currencyCodeList != null)
					&& (currencyNameList.size() != 0 || currencyNameList != null)) {
				message = "Currency Code and Currency Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showCurrencyJsp";

		try {
			map = generalMasterHandlerService.showCurrencyJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CURRENCY_JSP;
		title = "Add currency";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editCurrency(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currencyCode = "";
		String currencyName = "";
		int currencyId = 0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			currencyId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			currencyCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			currencyName = request.getParameter(SEARCH_NAME);
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

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		generalMap.put("userId", userId);
		generalMap.put("id", currencyId);
		generalMap.put("currencyCode", currencyCode);
		generalMap.put("name", currencyName);
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
			dataUpdated = generalMasterHandlerService
					.editCurrencyToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCurrencyNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showCurrencyJsp";
		try {
			map = generalMasterHandlerService.showCurrencyJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CURRENCY_JSP;
		title = "Update currency";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteCurrency(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int currencyId = 0;
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
			currencyId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		generalMap.put("userId", userId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteCurrency(currencyId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCurrencyJsp";
		try {
			map = generalMasterHandlerService.showCurrencyJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = CURRENCY_JSP;
		title = "Delete currency";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// -----------------------------------country -----------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showCountryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = generalMasterHandlerService.showCountryJsp();
		@SuppressWarnings("unused")
		ArrayList searchCountryList = (ArrayList) map.get("searchCountryList");
		jsp = COUNTRY_JSP;
		jsp += ".jsp";
		title = "Country";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCountry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasCountry masCountry = new MasCountry();

		int currencyId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(CURRENCY_ID) != null) {
			currencyId = Integer.valueOf(request.getParameter(CURRENCY_ID));

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
		List countryCodeList = new ArrayList();
		List countryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			countryCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			countryNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((countryCodeList.size() == 0 || countryCodeList == null)
				&& (countryNameList.size() == 0 || countryNameList == null))

		{
			masCountry.setCountryCode(code);
			masCountry.setCountryName(name);
			MasCurrency masCurrency = new MasCurrency();
			masCurrency.setId(currencyId);
			masCountry.setCurrency(masCurrency);

			masCountry.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			masCountry.setLastChgBy(users);

			masCountry.setLastChgDate(currentDate);
			masCountry.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addCountry(masCountry);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((countryCodeList.size() != 0 || countryCodeList != null)
				|| (countryNameList.size() != 0) || countryNameList != null) {

			if ((countryCodeList.size() != 0 || countryCodeList != null)
					&& (countryNameList.size() == 0 || countryNameList == null)) {

				message = "Country Code  already exists.";
			} else if ((countryNameList.size() != 0 || countryNameList != null)
					&& (countryCodeList.size() == 0 || countryCodeList == null)) {

				message = "Country Name  already exists.";
			} else if ((countryCodeList.size() != 0 || countryCodeList != null)
					&& (countryNameList.size() != 0 || countryNameList != null)) {

				message = "Country Code and Country Name already exist.";
			}
		}

		url = "/hms/hms/generalMaster?method=showCountryJsp";

		try {
			map = generalMasterHandlerService.showCountryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COUNTRY_JSP;
		title = "Add Country";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchCountry(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String countryCode = null;
		String countryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			countryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			countryName = request.getParameter(SEARCH_NAME);
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
			countryCode = searchField;
			countryName = null;
		} else {
			countryCode = null;
			countryName = searchField;
		}
		map = generalMasterHandlerService.searchCountry(countryCode,
				countryName);

		jsp = COUNTRY_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("countryCode", countryCode);
		map.put("countryName", countryName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editCountry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String countryCode = "";
		String countryName = "";
		int currencyId = 0;
		int countryId = 0;
		String changedBy = "";

		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		if (request.getParameter(CURRENCY_ID) != null
				&& !(request.getParameter(CURRENCY_ID).equals(""))) {
			currencyId = Integer.parseInt(request.getParameter(CURRENCY_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			countryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			countryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			countryName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", countryId);
		generalMap.put("countryCode", countryCode);
		generalMap.put("name", countryName);
		generalMap.put("currencyId", currencyId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCountryNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCountryNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editCountryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCountryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showCountryJsp";

		try {
			map = generalMasterHandlerService.showCountryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COUNTRY_JSP;
		title = "Edit Country";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteCountry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int countryId = 0;
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
			countryId = Integer.parseInt(request.getParameter(COMMON_ID));
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

		generalMap.put("userId", userId);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteCountry(countryId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCountryJsp";
		try {
			map = generalMasterHandlerService.showCountryJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COUNTRY_JSP;
		title = "delete Country";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------------------- Reference
	// ---------------------------------------

	public ModelAndView searchReference(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String referenceCode = null;
		String referenceName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			referenceCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			referenceName = request.getParameter(SEARCH_NAME);
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
			referenceCode = searchField;
			referenceName = null;

		} else {
			referenceCode = null;
			referenceName = searchField;
		}
		map = generalMasterHandlerService.searchReference(referenceCode,
				referenceName);
		jsp = REFERENCE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("referenceCode", referenceCode);
		map.put("referenceName", referenceName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showReferenceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = generalMasterHandlerService.showReferenceJsp();
		@SuppressWarnings("unused")
		ArrayList searchReferenceList = (ArrayList) map
				.get("searchReferenceList");
		jsp = REFERENCE_JSP;
		jsp += ".jsp";
		title = "Reference";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addReference(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasReference masReference = new MasReference();

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

		List referenceCodeList = new ArrayList();
		List referenceNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			referenceCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			referenceNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((referenceCodeList.size() == 0 || referenceCodeList == null)
				&& (referenceNameList.size() == 0 || referenceNameList == null)) {
			masReference.setReferenceCode(code);
			masReference.setReferenceName(name);
			masReference.setStatus("y");
			//masReference.setLastChgBy(changedBy);
			masReference.setLastChgDate(currentDate);
			masReference.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addReference(masReference);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((referenceCodeList.size() != 0 || referenceCodeList != null)
				|| (referenceNameList.size() != 0) || referenceNameList != null) {

			if ((referenceCodeList.size() != 0 || referenceCodeList != null)
					&& (referenceNameList.size() == 0 || referenceNameList == null)) {
				message = "Reference Code  already exists.";
			} else if ((referenceNameList.size() != 0 || referenceNameList != null)
					&& (referenceCodeList.size() == 0 || referenceCodeList == null)) {
				message = "Reference Name already exists.";
			} else if ((referenceCodeList.size() != 0 || referenceCodeList != null)
					&& (referenceNameList.size() != 0 || referenceNameList != null)) {

				message = "Reference Code and Reference Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showReferenceJsp";

		try {
			map = generalMasterHandlerService.showReferenceJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = REFERENCE_JSP;
		title = "Add Reference";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editReference(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String referenceCode = "";
		String referenceName = "";
		int referenceId = 0;
		String changedBy = "";
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		referenceCode = (String) session.getAttribute("referenceCode");
		referenceName = (String) session.getAttribute("referenceName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			referenceId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			referenceCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			referenceName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", referenceId);
		generalMap.put("referenceCode", referenceCode);
		generalMap.put("name", referenceName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingReferenceNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingReferenceNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editReferenceToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingReferenceNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showReferenceJsp";

		try {
			map = generalMasterHandlerService.showReferenceJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = REFERENCE_JSP;
		title = "edit Reference";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteReference(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int referenceId = 0;
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
			referenceId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteReference(referenceId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully!!";
		}
		url = "/hms/hms/generalMaster?method=showReferenceJsp";

		try {
			map = generalMasterHandlerService.showReferenceJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = REFERENCE_JSP;
		title = "delete Reference";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------generateReportsForBilling Replaced
	// Applet------------------

	public ModelAndView generateReportsForBilling(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();

		File reportFile = null;
		int hospitalId = 0;
		String jasper = null;
		String hospitalName = "";
		String billNo = "";
		String loginName = "";
		String billType = "";
		
		String dailyReport="";
		String fromDate = null;
		String toDate = null;
		String fromTime=null;
		String toTime=null;
		int receiptHeaderId=0;
		String Duplicate = "Duplicate";
		int inpatientId = 0;
		int bookingId = 0;

		if (request.getParameter("billNo") != null) {
			billNo = request.getParameter("billNo");
		}
		if (request.getParameter("receiptHeaderId") != null) {
			receiptHeaderId =Integer.parseInt(request.getParameter("receiptHeaderId"));
		}
		if (request.getParameter("loginName") != null) {
			loginName = request.getParameter("loginName");
		}
		if (request.getParameter("billtype") != null) {
			billType = request.getParameter("billtype");
			log.info("billType "+billType);
		}
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		}
		log.info("in report metehod "+bookingId);
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		// if (session.getAttribute("hospitalId") != null) {
		// hospitalId = (Integer) session.getAttribute("hospitalId");
		// mapForDs.put("hospitalId", hospitalId);
		// mapResponse = generalMasterHandlerService.getHospitalName(mapForDs);
		// }

		/*
		 * if (session.getAttribute("hospitalId") != null) { hospitalId =
		 * (Integer) session.getAttribute("hospitalId");
		 * mapForDs.put("hospitalId", hospitalId); mapResponse =
		 * generalMasterHandlerService.getHospitalName(mapForDs); }
		 * 
		 * if (mapResponse.get("masHospitaList") != null) { masHospitaList =
		 * (List) mapResponse.get("masHospitaList"); hospitalName =
		 * masHospitaList.get(0).getHospitalName();
		 * 
		 * }
		 * 
		 * if (request.getParameter(JASPER_FILE_NAME) != null) { jasper =
		 * request.getParameter(JASPER_FILE_NAME); }
		 */

		if (billType.equals("servicing")) {

			parameters.put("hospitalId", hospitalId);
			jasper = "bill_servicing";
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("dispensing")) {
			jasper = "BillDispensingsummary";
			parameters.put("billNo", billNo);
			parameters.put("hospitalId", hospitalId);
			parameters.put("loginname", loginName);
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("finalBill")) {
			jasper = "finalsettlementSummary";
			parameters.put("inpatientId", inpatientId);
			parameters.put("bookingId", bookingId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("patientDetail")) {
			jasper = "patientFinalsettlementDetail";
			//jasper = "finalBillsettlementDetail";
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("detail")) {
			jasper = "finalsettlementDetail";
			parameters.put("inpatientId", inpatientId);
			parameters.put("bookingId", bookingId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("finalBillSettlement")) {
			jasper = "finalBillSettlementSummary";
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("receipt")) {
			parameters.put("receiptHeaderId",receiptHeaderId);
			parameters.put("hospitalId", hospitalId);
			jasper = "acknowledgementForReceiptOfMoney";
			parameters.put("receiptNo", billNo);
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("chargeSlip")) {
			parameters.put("hospitalId", hospitalId);
			jasper = "ChargeSlip";
			parameters.put("billNo", Integer.parseInt(billNo));
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("refunds")) {
			parameters.put("hospitalId", hospitalId);
			parameters.put("refundno", billNo);
			jasper = "CashRefund";
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("servicingDup")) {
			parameters.put("hospitalId", hospitalId);
			//jasper = "Servicing_Bill";
			jasper = "bill_servicingDup";
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("Duplicate", Duplicate);
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("dispensingDup")) {
			jasper = "BillDispensingsummary";
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("Duplicate", Duplicate);
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("finalBillDup")) {
			jasper = "finalsettlementSummary";
			parameters.put("Duplicate", Duplicate);
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("finalBillSettlementDup")) {
			jasper = "finalBillSettlementSummary";
			parameters.put("Duplicate", Duplicate);
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("receiptDup")) {
			parameters.put("hospitalId", hospitalId);
			parameters.put("Duplicate", Duplicate);
			jasper = "Receipt";
			parameters.put("receiptNo", billNo);
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("chargeSlipDup")) {
			parameters.put("hospitalId", hospitalId);
			parameters.put("Duplicate", Duplicate);
			parameters.put("billNo", Integer.parseInt(billNo));
			jasper = "ChargeSlip";
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		} else if (billType.equals("refundsDup")) {
			parameters.put("Duplicate", Duplicate);
			parameters.put("refundno", billNo);
			parameters.put("hospitalId", hospitalId);
			jasper = "CashRefund";
			/*parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/
		}
		


		/*
		 * if (!reportFile.exists()) throw new JRRuntimeException(
		 * "File jasper file not found. The report design must be compiled first."
		 * );
		 * 
		 * parameters.put("hospitalName", hospitalName);
		 * parameters.put("SUBREPORT_DIR"
		 * ,getServletContext().getRealPath("/Reports/"));
		 */

		Map<String, Object> connectionMap = generalMasterHandlerService
				.getConnection();
		//added by govind 01-08-2017
		/*HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());*/
		
		map.put("Report_Path", request.getContextPath()+"/Reports/"+jasper+".pdf");
		HMSUtil.generateReportForDirectPrint(jasper, parameters,(Connection) connectionMap.get("conn"), response,getServletContext(),getServletContext().getRealPath("/Reports/"));//govind code 7-7-2016
	
		
				try{
					((Connection) connectionMap.get("conn")).close();
					}catch(Exception e){
						e.printStackTrace();
					}
				return new ModelAndView("printReports", "map", map);//added by govind 01-08-2017
	}


	public ModelAndView generateReportsForBillingExcel(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();

		File reportFile = null;
		int hospitalId = 0;
		String jasper = null;
		String hospitalName = "";
		String billNo = "";
		String loginName = "";
		String billType = "";
		String Duplicate = "Duplicate";  
		int inpatientId = 0;
		int mainChargeCodeId=0;

		if (request.getParameter("billNo") != null) {
			billNo = request.getParameter("billNo");
		}
		if (request.getParameter("loginName") != null) {
			loginName = request.getParameter("loginName");
		}
		if (request.getParameter("billtype") != null) {
			billType = request.getParameter("billtype");
		}
		
		log.info("bill Type" +billType);
		
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		// if (session.getAttribute("hospitalId") != null) {
		// hospitalId = (Integer) session.getAttribute("hospitalId");
		// mapForDs.put("hospitalId", hospitalId);
		// mapResponse = generalMasterHandlerService.getHospitalName(mapForDs);
		// }

		/*
		 * if (session.getAttribute("hospitalId") != null) { hospitalId =
		 * (Integer) session.getAttribute("hospitalId");
		 * mapForDs.put("hospitalId", hospitalId); mapResponse =
		 * generalMasterHandlerService.getHospitalName(mapForDs); }
		 * 
		 * if (mapResponse.get("masHospitaList") != null) { masHospitaList =
		 * (List) mapResponse.get("masHospitaList"); hospitalName =
		 * masHospitaList.get(0).getHospitalName();
		 * 
		 * }
		 * 
		 * if (request.getParameter(JASPER_FILE_NAME) != null) { jasper =
		 * request.getParameter(JASPER_FILE_NAME); }
		 */

		if (billType.equals("servicing")) {

			parameters.put("hospitalId", hospitalId);
			jasper = "bill_servicing";
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			
			String queryForBillServicing="select   md.department_name,   "+
					" bbh.op_bill_header_id,      "+
" charge_code_name as chargecodename,   hospital_name as hospitalname,   mh.address as hospitaladdress,   bbh.hin_id,      "+
" UPPER(patient_name) as name,   UPPER(next_of_kin_name) as next_of_kin_name ,      "+
" bbh.hin_no,   bbh.bill_no,   bbh.net_amt,   bbh.bill_date,      "+
" bbh.bill_time,   bbh.discount,      "+
" (bbd.rate*quantity) as rate_amt,   bbh.bill_amt,   bbd.amount,      "+
" bbd.quantity,coalesce(bbh.discount_amt,0) as discount_amt,coalesce(bbh.actual_collected_amt,0) as collected_amt,coalesce(brd.amount,0) as amt   from            bl_op_bill_header bbh   inner join        bl_op_bill_details bbd        on bbh.op_bill_header_id=bbd.op_bill_header_id   inner join        patient p                    on bbh.hin_id= p.hin_id   left outer join        mas_patient_type pt            on bbh.patient_type_id = pt.patient_type_id   left outer join mas_company mc                on bbh.company_id = mc.company_id   left outer join        mas_administrative_sex mas    on bbh.sex_id = mas.administrative_sex_id   inner join        mas_charge_code mcc            on bbd.charge_code_id=mcc.charge_code_id   inner join        mas_hospital mh                on bbh.hospital_id =mh.hospital_id   inner join        users u                        on bbh.changed_by=u.user_id   left join        bl_receipt_header brh        on bbh.op_bill_header_id= brh.op_bill_header_id   left join        bl_receipt_details brd        on brd.receipt_header_id= brh.receipt_header_id   left outer join visit vs                    on bbh.visit_id = vs.visit_id   "+
" left outer join mas_department md on md.department_id=mcc.department_id   where bbh.bill_no='"+billNo+"' and bbh.hospital_id="+hospitalId;
			List<Object[]> aList=new ArrayList<Object[]>();
			aList=generalMasterHandlerService.getDataForExcelReportServicing(queryForBillServicing);
			try{
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=Bill_servicing.xls");
				
				WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws = wb.createSheet("Bill Servicing", 0);
				
				WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);

				
				
				WritableFont wfForFooter = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				wfForFooter.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcForFooter = new WritableCellFormat(wfForFooter);
				wcForFooter.setAlignment(Alignment.CENTRE);

				
				
				
				
				WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
		//		wcf2.setWrap(true);
				wcf2.setShrinkToFit(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);
				
				
				WritableFont wf21= new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf21 = new WritableCellFormat(wf2);
				wcf21.setWrap(false);
				wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf21.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				WritableCellFormat wcf222 = new WritableCellFormat(wf222);
				wcf222.setWrap(true);
				wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf222.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);

/*				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf3.setVerticalAlignment(VerticalAlignment.TOP);
*/				
				WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
				WritableCellFormat wcf4 = new WritableCellFormat(wf4);
				wcf4.setWrap(true);
				wcf4.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
				WritableCellFormat wcf22 = new WritableCellFormat(wf22);
				wcf22.setWrap(true);
				wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf22.setVerticalAlignment(VerticalAlignment.TOP);
				if(session.getAttribute("hospitalName")!=null){
					hospitalName=""+session.getAttribute("hospitalName");
				}
				// hospitalName="";
				log.info("hospitalName, ----====>>"+hospitalName);
				ws.mergeCells(0,0,5,0);
				Label label = new Label(0,0,hospitalName,wcf);
				ws.addCell(label);

				ws.mergeCells(0,1,5,1);
				label = new Label(0,1,"Bill Servicing ",wcf);
				ws.addCell(label);
				
				ws.mergeCells(0,2,5,2);
				label = new Label(0,2,"OP Bill",wcf);
				ws.addCell(label);

/*				ws.mergeCells(0,1,3,1);
				label = new Label(0,2,"Receipt",wcf);
				ws.addCell(label);

				ws.mergeCells(4,5,7,5);
				label = new Label(8,2,"Payment",wcf);
				ws.addCell(label);
				

				ws.mergeCells(0,1,3,1);
				label = new Label(0,3,"Dr",wcf);
				ws.addCell(label);

				ws.mergeCells(4,5,7,5);
				label = new Label(8,3,"Cr",wcf);
				ws.addCell(label);
				
				
*/				
				
			/*	label = new Label(3,2,"Date :"+new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);*/
				/*ws.mergeCells(3,2,10,2);
				label = new Label(3,2,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);*/
				String patientName="";
				String date="";
				String billNo1="";
				String hinNo="";
				BigDecimal discount=new BigDecimal(0);	
				BigDecimal actualCollectedAmt=new BigDecimal(0);	
				BigDecimal amt=new BigDecimal(0);
				for(Object[] obj1 : aList){
					patientName=""+obj1[6];
					date=""+obj1[11];
					billNo=""+obj1[9];
					hinNo=""+obj1[8];
					discount=new BigDecimal(""+obj1[13]);
					actualCollectedAmt=new BigDecimal(""+obj1[19]);
					amt=new BigDecimal(""+obj1[20]);
					}
				label = new Label(0,4,"Patient Name ",wcf2);
				ws.addCell(label);
				label = new Label(1,4,patientName,wcf3);
				ws.addCell(label);

				label = new Label(2,4,"Date",wcf2);
				ws.addCell(label);
				
				label = new Label(3,4,date,wcf3);
				ws.addCell(label);
				
				label = new Label(0,5,"Bill No",wcf2);
				ws.addCell(label);
				label = new Label(1,5,billNo,wcf3);
				ws.addCell(label);

				label = new Label(2,5,"Registartion No.",wcf2);
				ws.addCell(label);
				
				label = new Label(3,5,hinNo,wcf3);
				ws.addCell(label);
				
				
				label = new Label(0,8,"Sr No. ",wcf2);
				ws.addCell(label);
				label = new Label(1,8,"Description",wcf2);
				ws.addCell(label);
				label = new Label(2,8,"Quantity",wcf2);
				ws.addCell(label);
				label = new Label(3,8,"Amount",wcf2);
				ws.addCell(label);

				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");
				String month=currentDate.substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				int slNo=1;
				if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
					slNo=31;
				}
				else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
					slNo=29;
				}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
					slNo=28;
				}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
					slNo=30;
				}
				
				
			int a=9;
			int a1=4;
/*			label = new Label(3,20,"Total",wcf3);
			ws.addCell(label);
*/			
			
			BigDecimal sum=new BigDecimal(0);
			
			BigDecimal paid=new BigDecimal(0);
			BigDecimal totalDiscount=new BigDecimal(0);
			BigDecimal rateAmt=new BigDecimal(0);
			int srNo=1;
			if(aList.size()>0){
					for(Object[] obj : aList){
					label = new Label(0,a,""+srNo,wcf3);
					ws.addCell(label);
					label = new Label(1,a,""+obj[2],wcf3);
					ws.addCell(label);
					label = new Label(2,a,""+obj[17],wcf3);
					ws.addCell(label);
					label = new Label(3,a,""+obj[14],wcf3);
					ws.addCell(label);
					sum=sum.add(new BigDecimal(""+obj[14]));
					discount=discount.add(new BigDecimal(""+obj[18]));
					paid=paid.add(new BigDecimal(""+obj[16]));
					rateAmt=rateAmt.add(new BigDecimal(""+obj[15]));
					/*
					label = new Label(2,a,"",wcf3);
					ws.addCell(label);
					label = new Label(3,a,"",wcf3);
					ws.addCell(label);
					label = new Label(4,a1+Integer.parseInt(obj[0].toString().substring(8,10)),obj[1].toString(),wcf3);
					
					sum=sum.add(new BigDecimal(obj[1].toString()));
					ws.addCell(label);	
					label = new Label(5,a,"",wcf3);
					ws.addCell(label);
					label = new Label(6,a,"",wcf3);
					ws.addCell(label);
					label = new Label(7,a,"",wcf3);
					ws.addCell(label);
					label = new Label(8,a,"",wcf3);
					ws.addCell(label);
					label = new Label(9,a,"",wcf3);
					ws.addCell(label);
					a++;
				*/
					a++;
					srNo++;
					}
				}
			
//			totalDiscount=discount.add
			a=a+3;
			label = new Label(2,a,"Total Amount",wcf2);
			ws.addCell(label);

			label = new Label(3,a,""+sum,wcf2);
			ws.addCell(label);

			a1=a+1;
			label = new Label(2,a1,"Total Discount",wcf2);
			ws.addCell(label);
			label = new Label(3,a1,""+discount,wcf2);
			ws.addCell(label);
			
			a1=a1+1;
			label = new Label(2,a1,"Total Bill",wcf2);
			ws.addCell(label);
			label = new Label(3,a1,""+sum.subtract(discount),wcf2);
			ws.addCell(label);
			
			
			a1=a1+1;
			label = new Label(2,a1,"Amount Paid",wcf2);
			ws.addCell(label);
			paid=actualCollectedAmt;
			label = new Label(3,a1,""+amt,wcf2);
			ws.addCell(label);
			a1=a1+1;
			
			
			label = new Label(2,a1,"Balance Amount",wcf2);
			ws.addCell(label);
			/*$V{SUM_rate_amt_1}.subtract( $F{amt} ).subtract($F{discount_amt}).subtract($F{discount})*/
			rateAmt=sum.subtract(discount).subtract(amt);
			
			label = new Label(3,a1,""+rateAmt,wcf2);
			ws.addCell(label);

			a1=a1+2;
/*			label = new Label(0,20,"Total",wcf3);
*/			ws.mergeCells(0,a1,5,a1);
			label = new Label(0,a1,"Received with Thanks sum of Rs."+amt+" from "+patientName,wcForFooter);
			ws.addCell(label);

			
			BigDecimal sumTotal=new BigDecimal(0);
			/*
			if(TotalExpense.size()>0){
				for(Object[] totalExp:TotalExpense){
					label = new Label(6,a1+Integer.parseInt(totalExp[0].toString().substring(8,10)),""+totalExp[0].toString().substring(8, 10).concat("/").concat(totalExp[0].toString().substring(5, 7)).concat("/").concat(totalExp[0].toString().substring(0, 4)),wcf3);
					ws.addCell(label);
					
					label = new Label(10,a1+Integer.parseInt(totalExp[0].toString().substring(8,10)),totalExp[1].toString(),wcf3);
					ws.addCell(label);
					sumTotal=sumTotal.add(new BigDecimal(totalExp[1].toString()));
				}
			}*/
			
			
			
			
			
			
			
				CellView cell = new CellView();
			    cell.setSize(5000);
			    ws.setColumnView(0, cell);

			    cell.setSize(8000);
			    ws.setColumnView(1, cell);

			    
			    cell.setSize(6000);
			    ws.setColumnView(2, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(3, cell);
			    
			    cell.setSize(600);
			    ws.setColumnView(5, cell);
			    
			    cell.setSize(3000);
			    ws.setColumnView(7, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(11, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(12, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(13, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(14, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(15, cell);
			
				wb.write();
				wb.close();
				return null;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try {

				response.setContentType("application/vnd.ms-excel");
				response.setHeader(
						"Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			
		} else if (billType.equals("dispensing")) {
			jasper = "BillDispensingsummary";
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));			
			
			
		} else if (billType.equals("finalBill")) {
			jasper = "finalsettlementSummary";
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
		
			
		} else if (billType.equals("patientDetail")) {
			jasper = "patientFinalsettlementDetail";
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			
			
			
				///////////////////////Nikhil - Final Bill//////////////////////////////////
			
			
			
		} else if (billType.equals("detail")) {
		//	parameters.put("hospitalId", hospitalId);
			jasper = "finalsettlementDetail";
			parameters.put("finalBillNo", billNo);
			parameters.put("loginname", loginName);
	//		parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			

			Map<String, Object> mapDetalis=new HashMap<String, Object>();
			mapDetalis.put("inpatientId", inpatientId);
			mapDetalis.put("hospitalId", hospitalId);
			mapDetalis.put("mainChargeCodeId", mainChargeCodeId);
			
			Map<String, Object> data=generalMasterHandlerService.getDataForExcel(mapDetalis);
			
			
			try{
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=Final_Settlement_Detail.xls");
				
				WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws = wb.createSheet("Final Settlement Detail", 0);
				ws.setProtected(true);
				
				WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);

				
				WritableFont wfForFooter = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				wfForFooter.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcForFooter = new WritableCellFormat(wfForFooter);
				wcForFooter.setAlignment(Alignment.CENTRE);

				WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
		//		wcf2.setWrap(true);
				wcf2.setShrinkToFit(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf5 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf5 = new WritableCellFormat(wf2);
		//		wcf2.setWrap(true);
				wcf5.setShrinkToFit(true);
				wcf5.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf5.setAlignment(Alignment.CENTRE);				
				
				WritableFont wf21= new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf21 = new WritableCellFormat(wf2);
				wcf21.setWrap(false);
				wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf21.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				WritableCellFormat wcf222 = new WritableCellFormat(wf222);
				wcf222.setWrap(true);
				wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf222.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);

/*				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf3.setVerticalAlignment(VerticalAlignment.TOP);
*/				
				WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
				WritableCellFormat wcf4 = new WritableCellFormat(wf4);
				wcf4.setWrap(true);
				wcf4.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
				WritableCellFormat wcf22 = new WritableCellFormat(wf22);
				wcf22.setWrap(true);
				wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf22.setVerticalAlignment(VerticalAlignment.TOP);
				if(session.getAttribute("hospitalName")!=null){
					hospitalName=""+session.getAttribute("hospitalName");
				}
				// hospitalName="";
				log.info("hospitalName "+hospitalName);
				ws.mergeCells(0,0,10,0);
				Label label = new Label(0,0,hospitalName,wcf);
				ws.addCell(label);

				ws.mergeCells(0,1,10,1);
				label = new Label(0,1,"IPD Bill ",wcf);
				ws.addCell(label);
				
				
				String patientName="";
				String printDate="";				
				String paddress="";
				String hinNo="";
				String ipdNo="";
				String disDateTime="";
				String wardName="";
				String bedNo="";
				String admDateTime="";
				String fBillNo="";
				String fBillDate="";
				
			
				for(Map.Entry<String, Object> obj2 : data.entrySet()){
					String mainchargeCodeName= obj2.getKey();
					List<Object[]> aList1= (List<Object[]>)obj2.getValue();
					
			//		System.err.println(mainchargeCodeName);
					
					for(Object[] obj1 : aList1){
						
						
					
					patientName=""+obj1[4];
					paddress=""+obj1[7];
					hinNo=""+obj1[5];
					ipdNo=""+obj1[27];
					disDateTime=""+obj1[10];
					wardName=""+obj1[12];
					bedNo=""+obj1[11];
					admDateTime=""+obj1[9];
					fBillNo=""+obj1[2];
					fBillDate=""+obj1[1];
						
					}
				}
			
				label = new Label(0,4,"Name",wcf2);
				ws.addCell(label);
				ws.mergeCells(1,4,3,4);
				label = new Label(1,4,patientName,wcf3);
				ws.addCell(label);
				
				ws.mergeCells(4,4,6,4);				
				label = new Label(4,4,"Print Date",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(7,4,10,4);	
				label = new Label(7,4,currentDate,wcf3);
				ws.addCell(label);
				
				label = new Label(0,5,"Address",wcf2);
				ws.addCell(label);
				ws.mergeCells(1,5,10,5);
				label = new Label(1,5,paddress,wcf3);
				ws.addCell(label);

				label = new Label(0,6,"Reg. No.",wcf2);
				ws.addCell(label);
				
				label = new Label(1,6,hinNo,wcf3);
				ws.addCell(label);
				
				label = new Label(2,6,"IPD No.",wcf2);
				ws.addCell(label);
				
				label = new Label(3,6,ipdNo,wcf3);
				ws.addCell(label);
				
				ws.mergeCells(4,6,6,6);
				label = new Label(4,6,"Discharge Date & Time",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(7,6,10,6);
				label = new Label(7,6,disDateTime,wcf3);
				ws.addCell(label);
				
				label = new Label(0,7,"Ward Name",wcf2);
				ws.addCell(label);
				
				label = new Label(1,7,wardName,wcf3);
				ws.addCell(label);
				
				label = new Label(2,7,"Bed No.",wcf2);
				ws.addCell(label);
				
				label = new Label(3,7,bedNo,wcf3);
				ws.addCell(label);
				
				ws.mergeCells(4,7,6,7);
				label = new Label(4,7,"Admission Date & Time",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(7,7,10,7);
				label = new Label(7,7,admDateTime,wcf3);
				ws.addCell(label);
				
				label = new Label(0,8,"Bill No.",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(1,8,3,8);
				label = new Label(1,8,fBillNo,wcf3);
				ws.addCell(label);
				
				ws.mergeCells(4,8,6,8);
				label = new Label(4,8,"Bill Date",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(7,8,10,8);
				label = new Label(7,8,fBillDate,wcf3);
				ws.addCell(label);
				
				
				
				ws.mergeCells(0,10,2,10);
				label = new Label(0,10,"Description ",wcf2);
				ws.addCell(label);
				
			//	ws.mergeCells(3,10,4,10);
				label = new Label(3,10,"No. of Times",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(4,10,6,10);
				label = new Label(4,10,"Charges",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(7,10,8,10);
				label = new Label(7,10,"Amount",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(9,10,10,10);
				label = new Label(9,10,"Discount",wcf2);
				ws.addCell(label);
				
				ws.mergeCells(0,9,10,9);
				

				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String currentTime = (String)utilMap.get("currentTime");
				String month=currentDate.substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				int slNo=1;
				if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
					slNo=31;
				}
				else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
					slNo=29;
				}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
					slNo=28;
				}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
					slNo=30;
				}
				
					
			int a=11;
			int a1=4;
			int a2=4;
			int a3=12;
			

			BigDecimal chargecodetotal= new BigDecimal(0);
			BigDecimal totalAmount=new BigDecimal(0);
			BigDecimal totalDiscount=new BigDecimal(0);
			BigDecimal paidAmount=new BigDecimal(0);
			BigDecimal balanceAmount=new BigDecimal(0);
			List<Object[]> aList= new ArrayList<Object[]>();
		//	int srNo=1;
			if(aList.size()>0){
									
						for(Object[] obj : aList){
							log.info(obj[20]+"   ");
							
					
						ws.mergeCells(0,a,10,a);
						label = new Label(0,a,""+obj[20],wcf2);
						ws.addCell(label);
							
						label = new Label(0,a3,""+obj[21],wcf3);
						ws.addCell(label);
									
						//	ws.mergeCells(3,a3,4,a3);
						label = new Label(3,a3,""+obj[15],wcf3);
						ws.addCell(label);
										
						ws.mergeCells(4,a3,6,a3);
						label = new Label(4,a3,""+obj[16],wcf3);
						ws.addCell(label);
										
						ws.mergeCells(7,a3,8,a3);
						label = new Label(7,a3,""+obj[17],wcf3);
						ws.addCell(label);
										
						ws.mergeCells(9,a3,10,a3);
						label = new Label(9,a3,""+obj[18],wcf3);
						ws.addCell(label);
						ws.mergeCells(0,a3,2,a3);
							
							
					//	chargecodetotal=(new BigDecimal(""+obj[17])).subtract(new BigDecimal(""+obj[18]));
							
						a3=a3+1;
						ws.mergeCells(0,a3,10,a3);
						label = new Label(0,a3,"Total of " +obj[20]+ ":" +obj[17] ,wcf5);
						ws.addCell(label);	

					totalAmount=totalAmount.add(new BigDecimal(""+obj[17]));			
					totalDiscount=totalDiscount.add(new BigDecimal(""+obj[18]));
					paidAmount=paidAmount.add(new BigDecimal(""+obj[3]));
					balanceAmount=balanceAmount.add(new BigDecimal(""+obj[26]));

					a3++;
					a=a3+2;
					
					}
				}
				
			
		//			totalDiscount=discount.add
					a=a+5;
					ws.mergeCells(3,a,6,a);
					label = new Label(3,a,"Total Amount",wcf2);
					ws.addCell(label);
					
					ws.mergeCells(7,a,10,a);
					label = new Label(7,a,""+totalAmount,wcf2);
					ws.addCell(label);
		
					a1=a+1;
					ws.mergeCells(3,a1,6,a1);
					label = new Label(3,a1,"Discount",wcf2);
					ws.addCell(label);
					ws.mergeCells(7,a1,10,a1);
					label = new Label(7,a1,""+totalDiscount,wcf2);
					ws.addCell(label);
					
					a2=a1+2;
					ws.mergeCells(3,a2,6,a2);
					label = new Label(3,a2,"Amount Paid",wcf2);
					ws.addCell(label);
					ws.mergeCells(7,a2,10,a2);
					label = new Label(7,a2,""+paidAmount,wcf2);
					ws.addCell(label);
					
					
					a2=a2+1;
					ws.mergeCells(3,a2,6,a2);
					label = new Label(3,a2,"Balance Amount",wcf2);
					ws.addCell(label);
					balanceAmount=totalAmount.subtract(totalDiscount).subtract(paidAmount);
					
					ws.mergeCells(7,a2,10,a2);
					label = new Label(7,a2,""+balanceAmount,wcf2);
					ws.addCell(label);
		
					a2=a2+2;
					ws.mergeCells(0,a2,10,a2);
					label = new Label(0,a2,"Received with Thanks sum of Rs."+paidAmount+" from "+patientName,wcForFooter);
					ws.addCell(label);
		
					
						CellView cell = new CellView();
					    cell.setSize(5000);
					    ws.setColumnView(0, cell);
		
					    cell.setSize(8000);
					    ws.setColumnView(1, cell);
		
					    
					    cell.setSize(6000);
					    ws.setColumnView(2, cell);
					    
					    cell.setSize(6000);
					    ws.setColumnView(3, cell);
					    
					    cell.setSize(600);
					    ws.setColumnView(5, cell);
					    
					    cell.setSize(3000);
					    ws.setColumnView(7, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(10, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(10, cell);
					    
					    cell.setSize(2000);
					    ws.setColumnView(11, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(12, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(13, cell);
					    
					    cell.setSize(2000);
					    ws.setColumnView(14, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(15, cell);
					
						wb.write();
						wb.close();
						return null;
				}catch(Exception e){
						e.printStackTrace();
					}
					
					try {
						//log.info(""+map.get("download_path").toString());
						response.setContentType("application/vnd.ms-excel");
						response.setHeader(
								"Content-Disposition",
								"attachment; filename="
										+ map.get("download_path").toString());
						File f = new File(map.get("download_path").toString());
						InputStream in = new FileInputStream(f);
						ServletOutputStream outs = response.getOutputStream();
						int bit = 256;
						int i = 0;
						while ((bit) >= 0) {
							bit = in.read();
							outs.write(bit);
						}
						outs.flush();
						outs.close();
						in.close();
						if (f.exists())
							f.delete();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
			
			
			//////////////------------------------------------------------
								
		} else if (billType.equals("finalBillSettlement")) {
			jasper = "finalBillSettlementSummary";
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			
			
					
			
			
			
		} else if (billType.equals("receipt")) {
			parameters.put("hospitalId", hospitalId);
			jasper = "Receipt";
			parameters.put("receiptNo", billNo);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			
			
////////////////------------------------------Nikhil-----------------------------------------
			
			
		} else if (billType.equals("chargeSlip")) {
			parameters.put("hospitalId", hospitalId);
			jasper = "ChargeSlip";
			parameters.put("chargeSlipNo", Integer.parseInt(billNo));
			parameters.put("loginname", loginName);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			
					
		 String queryForChargeSlip="SELECT distinct blcs.charge_slip_main_id ,   " + "     masc.charge_code_name, " + "       mh.hospital_name,   " + "       mh.address, " + "        p.hin_id,  " + "       UPPER((p_first_name||' '||coalesce(p_middle_name,' ')||' '||coalesce(p_last_name,' '))) as patientName,   " +  
		 
		" u.user_name as username,  " + "       p.hin_no as hinNo,    " + "       blcs.charge_slip_no as slipNo,   " + "      blcd.amt,    " + "      blcs.chg_slp_time,  " + "        blcs.chg_slp_amt as totalAmount,    " + "         blcs.net_amt as netAmount, " + "        blcs.chg_slp_date as date,  " +   
		 
		" p.registration_type,      blcd.quantity,   " + "       blcs.receipt_amt, " + "         bh.receipt_date,   " + 
		
		" coalesce(blcs.discount_amt,0) as discount_amt,    " + 
		 
		" case when blcs.discount_amt is null then 0 else (case  when (pt.patient_type_code ='STF' or pt.patient_type_code = 'DEP') then blcs.discount_amt else blcs.discount_amt end)end as distype,  " +   

		" case when blcs.receipt_amt !=0 then blcs.receipt_amt else 0 end as cash_amt,    " + 
		
		" case when blcs.receipt_amt !=0 then blcs.receipt_amt else 0 end as advane,    " + 
		
		" case when blcs.receipt_amt !=0 then blcs.os_amt else 0 end as advanec_amt     " + 
		
		" from bl_charge_slip_main  blcs inner join bl_charge_slip_detail blcd on blcs.charge_slip_main_id = blcd.charge_slip_main_id  inner join patient p  on blcs.hin_id= p.hin_id   inner join   mas_hospital mh    on blcs.hospital_id =mh.hospital_id  inner join   users u    on blcs.last_chg_by= u.user_id   " +   
						
		" left outer join mas_charge_code masc on blcd.charge_code_id = masc.charge_code_id " +    

		" left outer join bl_receipt_header bh on blcs.inpatient_id = bh.inpatient_id   and  blcs.chg_slp_date= bh.receipt_date " + 

		" left outer join mas_company mc on blcs.company_id = mc.company_id " + 

		" left outer join mas_patient_type pt on blcs.patient_type_id = pt.patient_type_id where blcs.charge_slip_no = '"+billNo+"'  and blcs.hospital_id = "+hospitalId;

								 						
						
								List<Object[]> aList=new ArrayList<Object[]>();
							aList=generalMasterHandlerService.getDataForExcelReportChargeSlip(queryForChargeSlip);
							try{
								   
								   response.setContentType("application/vnd.ms-excel");
									response.setHeader("Content-Disposition","attachment; filename=ChargeSlip.xls");			
									
									WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
									WritableSheet ws = wb.createSheet("Charge Slip", 0);
									ws.setProtected(true);
									
									WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
									wf.setUnderlineStyle(UnderlineStyle.SINGLE);
									WritableCellFormat wcf = new WritableCellFormat(wf);
									wcf.setAlignment(Alignment.CENTRE);

									
									
									WritableFont wfForFooter = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
									wfForFooter.setUnderlineStyle(UnderlineStyle.SINGLE);
									WritableCellFormat wcForFooter = new WritableCellFormat(wfForFooter);
									wcForFooter.setAlignment(Alignment.CENTRE);
											
									
									
									WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
									WritableCellFormat wcf2 = new WritableCellFormat(wf2);
						//			wcf2.setWrap(true);
									wcf2.setShrinkToFit(true);
									wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
									wcf2.setVerticalAlignment(VerticalAlignment.TOP);
									
									
									WritableFont wf21= new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
									WritableCellFormat wcf21 = new WritableCellFormat(wf2);
									wcf21.setWrap(false);
									wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
									wcf21.setVerticalAlignment(VerticalAlignment.TOP);
									
									WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
									WritableCellFormat wcf222 = new WritableCellFormat(wf222);
									wcf222.setWrap(true);
									wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
									wcf222.setVerticalAlignment(VerticalAlignment.TOP);
									
									WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
									WritableCellFormat wcf3 = new WritableCellFormat(wf3);
									wcf3.setWrap(true);
									wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);

						/*				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
									wcf3.setVerticalAlignment(VerticalAlignment.TOP);
						*/				
									WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
									WritableCellFormat wcf4 = new WritableCellFormat(wf4);
									wcf4.setWrap(true);
									wcf4.setVerticalAlignment(VerticalAlignment.TOP);
									
									WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
									WritableCellFormat wcf22 = new WritableCellFormat(wf22);
									wcf22.setWrap(true);
									wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
									wcf22.setVerticalAlignment(VerticalAlignment.TOP);
									if(session.getAttribute("hospitalName")!=null){
										hospitalName=""+session.getAttribute("hospitalName");
									}
									// hospitalName="";
									log.info("hospitalName  "+hospitalName);
									ws.mergeCells(0,0,5,0);
									Label label = new Label(0,0,hospitalName,wcf);
									ws.addCell(label);

									ws.mergeCells(0,1,5,1);
									label = new Label(0,1,"Charge Slip ",wcf);
									ws.addCell(label);
									
	
									
									
								/*	label = new Label(3,2,"Date :"+new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
									ws.addCell(label);*/
									/*ws.mergeCells(3,2,10,2);
									label = new Label(3,2,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
									ws.addCell(label);*/
									
															
								
									String patientName="";		
									String hinNo="";
									String slipNo="";
									String date="";
									
							//		BigDecimal amount =new BigDecimal(0);
									
													
																	
									for(Object[] obj1 : aList){
										patientName=""+obj1[5];
										hinNo=""+obj1[7];
										slipNo=""+obj1[8];										
										date=""+obj1[13];
									//	amount=new BigDecimal(""+obj1[9]);
											
										}
									
									label = new Label(0,4,"Patient Name",wcf2);
									ws.addCell(label);
									
									label = new Label(1,4,patientName,wcf3);
									ws.addCell(label);
									
									label = new Label(2,4,"Registration No.",wcf2);
									ws.addCell(label);
									label = new Label(3,4,hinNo,wcf3);
									ws.addCell(label);
									
									label = new Label(0,5,"Slip No.",wcf2);
									ws.addCell(label);
									label = new Label(1,5,slipNo,wcf3);
									ws.addCell(label);

									label = new Label(2,5,"Date",wcf2);
									ws.addCell(label);
									
									label = new Label(3,5,date,wcf3);
									ws.addCell(label);
									
					
																	
																	
									label = new Label(0,8,"Sr No. ",wcf2);
									ws.addCell(label);
									label = new Label(1,8,"Charge",wcf2);
									ws.addCell(label);
									
									ws.mergeCells(2,8,3,8);
									label = new Label(2,8,"Amount",wcf2);
									ws.addCell(label);
									
									
														

									Map<String,Object> utilMap = new HashMap<String,Object>();
									utilMap = (Map)HMSUtil.getCurrentDateAndTime();
									String currentDate = (String)utilMap.get("currentDate");
									String currentime = (String)utilMap.get("currentTime");
									String month=currentDate.substring(3,5);
									String monthName=HMSUtil.getMonthName(month);
									int slNo=1;

									if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
										slNo=31;
									}
									else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
										slNo=29;
									}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
										slNo=28;
									}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
										slNo=30;
									}
									
								int a=9;
								
								int a1=10;
								
					
								
								BigDecimal sum=new BigDecimal(0);
								BigDecimal discount=new BigDecimal(0);
								BigDecimal netAmount=new BigDecimal(0);
								
				//				BigDecimal totalDiscount=new BigDecimal(0);
				//				BigDecimal rateAmt=new BigDecimal(0);
						
								
					//			String remarks="";
								String username="";				

								int srNo=1;
								if(aList.size()>0){
										for(Object[] obj : aList){
										label = new Label(0,a,""+srNo,wcf3);
										ws.addCell(label);
										
										label = new Label(1,a,""+obj[1],wcf3);
										ws.addCell(label);
										
										ws.mergeCells(2,a,3,a);
										label = new Label(2,a,""+obj[9],wcf3);
										ws.addCell(label);
										
										sum=sum.add(new BigDecimal(""+obj[9]));															
										netAmount=netAmount.add(new BigDecimal(""+obj[12]));
													
										
										a++;
										srNo++;
										}
									}
								
								a=a+3;
								label = new Label(2,a,"Total Amount",wcf2);
								ws.addCell(label);

								label = new Label(3,a,""+sum,wcf2);
								ws.addCell(label);
								
								
								a1=a+1;
								label = new Label(2,a1,"Net Amount",wcf2);
								ws.addCell(label);
								
								label = new Label(3,a1,""+sum.subtract(discount),wcf2);
								ws.addCell(label);
								
								
								a1=a1+3;
								label = new Label(2,a1,"Cashier",wcf2);
								ws.addCell(label);
															
								label = new Label(3,a1,""+username,wcf2);
								ws.addCell(label);
										
										
								a1=a1+4;
								ws.mergeCells(0,a1,5,a1);
								label = new Label(0,a1,"Received with Thanks sum of Rs."+sum.subtract(discount)+" from "+patientName,wcForFooter);
								ws.addCell(label);
								
								
								
								
									CellView cell = new CellView();
								    cell.setSize(5000);
								    ws.setColumnView(0, cell);

								    cell.setSize(8000);
								    ws.setColumnView(1, cell);

								    
								    cell.setSize(6000);
								    ws.setColumnView(2, cell);
								    
								    cell.setSize(6000);
								    ws.setColumnView(3, cell);
								    
								    cell.setSize(600);
								    ws.setColumnView(5, cell);
								    
								    cell.setSize(3000);
								    ws.setColumnView(7, cell);
								    
								    cell.setSize(1500);
								    ws.setColumnView(10, cell);
								    
								    cell.setSize(1500);
								    ws.setColumnView(10, cell);
								    
								    cell.setSize(2000);
								    ws.setColumnView(11, cell);
								    
								    cell.setSize(1500);
								    ws.setColumnView(12, cell);
								    
								    cell.setSize(1500);
								    ws.setColumnView(13, cell);
								    
								    cell.setSize(2000);
								    ws.setColumnView(14, cell);
								    
								    cell.setSize(1500);
								    ws.setColumnView(15, cell);
								
									wb.write();
									wb.close();
									return null;
								}catch(Exception e){
									e.printStackTrace();
								}
								
								try {
						
									response.setContentType("application/vnd.ms-excel");
									response.setHeader(
											"Content-Disposition",
											"attachment; filename="
													+ map.get("download_path").toString());
									File f = new File(map.get("download_path").toString());
									InputStream in = new FileInputStream(f);
									ServletOutputStream outs = response.getOutputStream();
									int bit = 256;
									int i = 0;
									while ((bit) >= 0) {
										bit = in.read();
										outs.write(bit);
									}
									outs.flush();
									outs.close();
									in.close();
									if (f.exists())
										f.delete();
								} catch (IOException ioe) {
									ioe.printStackTrace();
								}
			
			
			
			
			
		} else if (billType.equals("refunds")) {
			parameters.put("hospitalId", hospitalId);
			jasper = "CashRefund";
			parameters.put("refundno", billNo);
			parameters.put("loginname", loginName);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			
			
			
			 String queryForCashRefund="SELECT bd.hospital_id,"  +  " bd.hin_id, bd.inpatient_id, "   +  "  UPPER(u.user_name) as username," +  " (SELECT hin_no FROM patient WHERE hin_id =bd.hin_id ) AS hinNo," +

				" bd.refund_no AS refundNo, bd.refund_date AS refundDate, bd.refund_time AS refundTime," + " coalesce(bd.total_refund_amt,0) AS totalreFundAmt, bd.remarks, " +

				" (case hd.payment_mode when 'C' then 'Cash Refund' when 'Q' then ('Cheque No :' || ' ' || hd.cheque_no || ' Date : '|| cast(hd.cheque_date as varchar(20))) else ('Card No :' || ' ' || hd.cheque_no || ' Date: '|| cast(hd.cheque_date as varchar(20))) end) as details," +         

				" hd.refund_amount," + " (SELECT UPPER((p_first_name||' '||coalesce(p_middle_name,' ')||' '||coalesce(p_last_name,' '))) as patientName FROM patient WHERE hin_id =bd.hin_id ) as patientname," +

				" (SELECT hospital_name FROM mas_hospital WHERE hospital_id = bd.hospital_id) as hospitalname," +

				" (SELECT address FROM mas_hospital WHERE hospital_id =bd.hospital_id) as hospitaladdress  FROM (SELECT * FROM  bl_refund_header where refund_no = '"+billNo+"'  and hospital_id = "+hospitalId+") bd " + 

				" LEFT JOIN users u ON bd.last_chg_by  = u.user_id  ,"  +   " bl_refund_details hd  WHERE	 bd.refund_header_id  = hd.refund_header_id " ; 

	     
			List<Object[]> aList=new ArrayList<Object[]>();
		aList=generalMasterHandlerService.getDataForExcelReportCashRefund(queryForCashRefund);
		try{
			   
			   response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=CashRefund.xls");			
				
				WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws = wb.createSheet("Cash Refund", 0);
				ws.setProtected(true);
				
				WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);

				WritableFont wfForFooter = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				wfForFooter.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcForFooter = new WritableCellFormat(wfForFooter);
				wcForFooter.setAlignment(Alignment.CENTRE);
											
				WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
		//		wcf2.setWrap(true);
				wcf2.setShrinkToFit(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);
								
				WritableFont wf21= new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf21 = new WritableCellFormat(wf2);
				wcf21.setWrap(false);
				wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf21.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				WritableCellFormat wcf222 = new WritableCellFormat(wf222);
				wcf222.setWrap(true);
				wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf222.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);

	/*				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf3.setVerticalAlignment(VerticalAlignment.TOP);
	*/				
				WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
				WritableCellFormat wcf4 = new WritableCellFormat(wf4);
				wcf4.setWrap(true);
				wcf4.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
				WritableCellFormat wcf22 = new WritableCellFormat(wf22);
				wcf22.setWrap(true);
				wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf22.setVerticalAlignment(VerticalAlignment.TOP);
				if(session.getAttribute("hospitalName")!=null){
					hospitalName=""+session.getAttribute("hospitalName");
				}
				// hospitalName="";
				log.info("hospitalName  "+hospitalName);
				ws.mergeCells(0,0,5,0);
				Label label = new Label(0,0,hospitalName,wcf);
				ws.addCell(label);

				ws.mergeCells(0,1,5,1);
				label = new Label(0,1,"Cash Refund ",wcf);
				ws.addCell(label);
				
					
				String hinNo="";
				String refundNo="";
				String patientName="";				
				String refundDate="";
				String refundTime="";
				
				String remarks="";
				String username="";					
			
		
				for(Object[] obj1 : aList){
					hinNo=""+obj1[4];
					refundNo=""+obj1[5];
					patientName=""+obj1[12];
					refundDate=""+obj1[6];
					refundTime=""+obj1[7];
					
					remarks=""+obj1[9];
					username=""+obj1[3];
					}
				label = new Label(0,4,"Registartion No.",wcf2);
				ws.addCell(label);
				label = new Label(1,4,hinNo,wcf3);
				ws.addCell(label);
				
				label = new Label(2,4,"Refund No",wcf2);
				ws.addCell(label);
				label = new Label(3,4,refundNo,wcf3);
				ws.addCell(label);
				
				label = new Label(0,5,"Patient Name ",wcf2);
				ws.addCell(label);
				label = new Label(1,5,patientName,wcf3);
				ws.addCell(label);

				label = new Label(2,5,"Date",wcf2);
				ws.addCell(label);
				label = new Label(3,5,refundDate,wcf3);
				ws.addCell(label);
				
				label = new Label(2,6,"Time",wcf2);
				ws.addCell(label);
				label = new Label(3,6,refundTime,wcf3);
				ws.addCell(label);
												
				label = new Label(0,9,"Sr No. ",wcf2);
				ws.addCell(label);
				label = new Label(1,9,"Details",wcf2);
				ws.addCell(label);
				ws.mergeCells(2,9,3,9);
				label = new Label(2,9,"Amount",wcf2);
				ws.addCell(label);
				
				
				
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String currentime = (String)utilMap.get("currentTime");
				String month=currentDate.substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				int slNo=1;

				if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
					slNo=31;
				}
				else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
					slNo=29;
				}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
					slNo=28;
				}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
					slNo=30;
				}
				
			int a=10;
			
			int a1=4;
					
			
			BigDecimal totalRefundAmt=new BigDecimal(0);
	
			int srNo=1;
			if(aList.size()>0){
					for(Object[] obj : aList){
					label = new Label(0,a,""+srNo,wcf3);
					ws.addCell(label);
					
					label = new Label(1,a,""+obj[10],wcf3);
					ws.addCell(label);
					
					
					ws.mergeCells(2,a,3,a);
					label = new Label(2,a,""+obj[11],wcf3);
					ws.addCell(label);
					
					
					totalRefundAmt=totalRefundAmt.add(new BigDecimal(""+obj[11]));
					
					a++;
				
					srNo++;
					}
				}
			
			ws.mergeCells(1,8,3,8);
			label = new Label(0,8,"Total Refund",wcf2);
			ws.addCell(label);
			label = new Label(1,8,""+totalRefundAmt,wcf2);
			ws.addCell(label);
			
			a=a+3;
			
			ws.mergeCells(1,a,3,a);
			label = new Label(0,a,"Remarks",wcf2);
			ws.addCell(label);

			label = new Label(1,a,remarks,wcf2);
			ws.addCell(label);

			a1=a+1;
			label = new Label(2,a1,"Signature",wcf2);
			ws.addCell(label);
			
			a1=a1+1;
			label = new Label(2,a1,"Cashier",wcf2);
			ws.addCell(label);
			
			label = new Label(3,a1,username,wcf2);
			ws.addCell(label);
					
			
				CellView cell = new CellView();
			    cell.setSize(5000);
			    ws.setColumnView(0, cell);

			    cell.setSize(8000);
			    ws.setColumnView(1, cell);

			    
			    cell.setSize(6000);
			    ws.setColumnView(2, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(3, cell);
			    
			    cell.setSize(600);
			    ws.setColumnView(5, cell);
			    
			    cell.setSize(3000);
			    ws.setColumnView(7, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(11, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(12, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(13, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(14, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(15, cell);
			
				wb.write();
				wb.close();
				return null;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try {
	
				response.setContentType("application/vnd.ms-excel");
				response.setHeader(
						"Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			
			
			
		}else if (billType.equals("servicingDup")) {
			/*parameters.put("hospitalId", hospitalId);
			jasper = "Servicing_Bill";
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("Duplicate", Duplicate);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));*/


			parameters.put("hospitalId", hospitalId);
			jasper = "bill_servicing";
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_VN_RKS",
					getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			
			String queryForBillServicing="select   md.department_name,   "+
					" bbh.op_bill_header_id,      "+
" charge_code_name as chargecodename,   hospital_name as hospitalname,   mh.address as hospitaladdress,   bbh.hin_id,      "+
" UPPER(patient_name) as name,   UPPER(next_of_kin_name) as next_of_kin_name ,      "+
" bbh.hin_no,   bbh.bill_no,   bbh.net_amt,   bbh.bill_date,      "+
" bbh.bill_time,   bbh.discount,      "+
" (bbd.rate*quantity) as rate_amt,   bbh.bill_amt,   bbd.amount,      "+
" bbd.quantity,coalesce(bbh.discount_amt,0) as discount_amt,coalesce(bbh.actual_collected_amt,0) as collected_amt,coalesce(brd.amount,0) as amt   from            bl_op_bill_header bbh   inner join        bl_op_bill_details bbd        on bbh.op_bill_header_id=bbd.op_bill_header_id   inner join        patient p                    on bbh.hin_id= p.hin_id   left outer join        mas_patient_type pt            on bbh.patient_type_id = pt.patient_type_id   left outer join mas_company mc                on bbh.company_id = mc.company_id   left outer join        mas_administrative_sex mas    on bbh.sex_id = mas.administrative_sex_id   inner join        mas_charge_code mcc            on bbd.charge_code_id=mcc.charge_code_id   inner join        mas_hospital mh                on bbh.hospital_id =mh.hospital_id   inner join        users u                        on bbh.changed_by=u.user_id   left join        bl_receipt_header brh        on bbh.op_bill_header_id= brh.op_bill_header_id   left join        bl_receipt_details brd        on brd.receipt_header_id= brh.receipt_header_id   left outer join visit vs                    on bbh.visit_id = vs.visit_id   "+
" left outer join mas_department md on md.department_id=mcc.department_id   where bbh.bill_no='"+billNo+"' and bbh.hospital_id="+hospitalId;
			List<Object[]> aList=new ArrayList<Object[]>();
			aList=generalMasterHandlerService.getDataForExcelReportServicing(queryForBillServicing);
			try{
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=Bill_servicing.xls");
				
				WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws = wb.createSheet("Bill Servicing", 0);
				ws.setProtected(true);
				
				WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);

				
				
				WritableFont wfForFooter = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				wfForFooter.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcForFooter = new WritableCellFormat(wfForFooter);
				wcForFooter.setAlignment(Alignment.CENTRE);

				
				WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
		//		wcf2.setWrap(true);
				wcf2.setShrinkToFit(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);
				
				
				WritableFont wf21= new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf21 = new WritableCellFormat(wf2);
				wcf21.setWrap(false);
				wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf21.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				WritableCellFormat wcf222 = new WritableCellFormat(wf222);
				wcf222.setWrap(true);
				wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf222.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);

/*				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf3.setVerticalAlignment(VerticalAlignment.TOP);
*/				
				WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
				WritableCellFormat wcf4 = new WritableCellFormat(wf4);
				wcf4.setWrap(true);
				wcf4.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
				WritableCellFormat wcf22 = new WritableCellFormat(wf22);
				wcf22.setWrap(true);
				wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf22.setVerticalAlignment(VerticalAlignment.TOP);
				if(session.getAttribute("hospitalName")!=null){
					hospitalName=""+session.getAttribute("hospitalName");
				}
				// hospitalName="";
				log.info("hospitalName ---"+hospitalName);
				ws.mergeCells(0,0,5,0);
				Label label = new Label(0,0,hospitalName,wcf);
				ws.addCell(label);

				ws.mergeCells(0,1,5,1);
				label = new Label(0,1,"Bill Servicing ",wcf);
				ws.addCell(label);
				
				ws.mergeCells(0,2,5,2);
				label = new Label(0,2,"OP Bill",wcf);
				ws.addCell(label);

/*				ws.mergeCells(0,1,3,1);
				label = new Label(0,2,"Receipt",wcf);
				ws.addCell(label);

				ws.mergeCells(4,5,7,5);
				label = new Label(8,2,"Payment",wcf);
				ws.addCell(label);
				

				ws.mergeCells(0,1,3,1);
				label = new Label(0,3,"Dr",wcf);
				ws.addCell(label);

				ws.mergeCells(4,5,7,5);
				label = new Label(8,3,"Cr",wcf);
				ws.addCell(label);
				
*/				
				
			/*	label = new Label(3,2,"Date :"+new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);*/
				/*ws.mergeCells(3,2,10,2);
				label = new Label(3,2,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);*/
				String patientName="";
				String date="";
				String billNo1="";
				String hinNo="";
				BigDecimal discount=new BigDecimal(0);	
				BigDecimal actualCollectedAmt=new BigDecimal(0);	
				BigDecimal amt=new BigDecimal(0);
				for(Object[] obj1 : aList){
					patientName=""+obj1[6];
					date=""+obj1[11];
					billNo=""+obj1[9];
					hinNo=""+obj1[8];
					discount=new BigDecimal(""+obj1[13]);
					actualCollectedAmt=new BigDecimal(""+obj1[19]);
					amt=new BigDecimal(""+obj1[20]);
					}
				label = new Label(0,4,"Patient Name ",wcf2);
				ws.addCell(label);
				label = new Label(1,4,patientName,wcf3);
				ws.addCell(label);

				label = new Label(2,4,"Date",wcf2);
				ws.addCell(label);
				
				label = new Label(3,4,date,wcf3);
				ws.addCell(label);
				
				label = new Label(0,5,"Bill No",wcf2);
				ws.addCell(label);
				label = new Label(1,5,billNo,wcf3);
				ws.addCell(label);

				label = new Label(2,5,"Registartion No.",wcf2);
				ws.addCell(label);
				
				label = new Label(3,5,hinNo,wcf3);
				ws.addCell(label);
				
				
				label = new Label(0,8,"Sr No. ",wcf2);
				ws.addCell(label);
				label = new Label(1,8,"Description",wcf2);
				ws.addCell(label);
				label = new Label(2,8,"Quantity",wcf2);
				ws.addCell(label);
				label = new Label(3,8,"Amount",wcf2);
				ws.addCell(label);

				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");
				String month=currentDate.substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				int slNo=1;
				if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
					slNo=31;
				}
				else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
					slNo=29;
				}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
					slNo=28;
				}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
					slNo=30;
				}
				
				
			int a=9;
			int a1=4;
/*			label = new Label(3,20,"Total",wcf3);
			ws.addCell(label);
*/			
			
			BigDecimal sum=new BigDecimal(0);
			
			BigDecimal paid=new BigDecimal(0);
			BigDecimal totalDiscount=new BigDecimal(0);
			BigDecimal rateAmt=new BigDecimal(0);
			int srNo=1;
			if(aList.size()>0){
					for(Object[] obj : aList){
					label = new Label(0,a,""+srNo,wcf3);
					ws.addCell(label);
					label = new Label(1,a,""+obj[2],wcf3);
					ws.addCell(label);
					label = new Label(2,a,""+obj[17],wcf3);
					ws.addCell(label);
					label = new Label(3,a,""+obj[14],wcf3);
					ws.addCell(label);
					sum=sum.add(new BigDecimal(""+obj[14]));
					discount=discount.add(new BigDecimal(""+obj[18]));
					paid=paid.add(new BigDecimal(""+obj[16]));
					rateAmt=rateAmt.add(new BigDecimal(""+obj[15]));
					/*
					label = new Label(2,a,"",wcf3);
					ws.addCell(label);
					label = new Label(3,a,"",wcf3);
					ws.addCell(label);
					label = new Label(4,a1+Integer.parseInt(obj[0].toString().substring(8,10)),obj[1].toString(),wcf3);
					
					sum=sum.add(new BigDecimal(obj[1].toString()));
					ws.addCell(label);	
					label = new Label(5,a,"",wcf3);
					ws.addCell(label);
					label = new Label(6,a,"",wcf3);
					ws.addCell(label);
					label = new Label(7,a,"",wcf3);
					ws.addCell(label);
					label = new Label(8,a,"",wcf3);
					ws.addCell(label);
					label = new Label(9,a,"",wcf3);
					ws.addCell(label);
					a++;
				*/
					a++;
					srNo++;
					}
				}
			
//			totalDiscount=discount.add
			a=a+3;
			label = new Label(2,a,"Total Amount",wcf2);
			ws.addCell(label);

			label = new Label(3,a,""+sum,wcf2);
			ws.addCell(label);

			a1=a+1;
			label = new Label(2,a1,"Total Discount",wcf2);
			ws.addCell(label);
			label = new Label(3,a1,""+discount,wcf2);
			ws.addCell(label);
			
			a1=a1+1;
			label = new Label(2,a1,"Total Bill",wcf2);
			ws.addCell(label);
			label = new Label(3,a1,""+sum.subtract(discount),wcf2);
			ws.addCell(label);
			
			
			a1=a1+1;
			label = new Label(2,a1,"Amount Paid",wcf2);
			ws.addCell(label);
			paid=actualCollectedAmt;
			label = new Label(3,a1,""+amt,wcf2);
			ws.addCell(label);
			a1=a1+1;
			
			
			label = new Label(2,a1,"Balance Amount",wcf2);
			ws.addCell(label);
			/*$V{SUM_rate_amt_1}.subtract( $F{amt} ).subtract($F{discount_amt}).subtract($F{discount})*/
			rateAmt=sum.subtract(discount).subtract(amt);
			
			
			label = new Label(3,a1,""+rateAmt,wcf2);
			ws.addCell(label);

			a1=a1+2;
/*			label = new Label(0,20,"Total",wcf3);
*/			ws.mergeCells(0,a1,5,a1);
			label = new Label(0,a1,"Received with Thanks sum of Rs."+amt+" from "+patientName,wcForFooter);
			ws.addCell(label);

			
			BigDecimal sumTotal=new BigDecimal(0);
			/*
			if(TotalExpense.size()>0){
				for(Object[] totalExp:TotalExpense){
					label = new Label(6,a1+Integer.parseInt(totalExp[0].toString().substring(8,10)),""+totalExp[0].toString().substring(8, 10).concat("/").concat(totalExp[0].toString().substring(5, 7)).concat("/").concat(totalExp[0].toString().substring(0, 4)),wcf3);
					ws.addCell(label);
					
					label = new Label(10,a1+Integer.parseInt(totalExp[0].toString().substring(8,10)),totalExp[1].toString(),wcf3);
					ws.addCell(label);
					sumTotal=sumTotal.add(new BigDecimal(totalExp[1].toString()));
				}
			}*/
			
				CellView cell = new CellView();
			    cell.setSize(5000);
			    ws.setColumnView(0, cell);

			    cell.setSize(8000);
			    ws.setColumnView(1, cell);

			    
			    cell.setSize(6000);
			    ws.setColumnView(2, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(3, cell);
			    
			    cell.setSize(600);
			    ws.setColumnView(5, cell);
			    
			    cell.setSize(3000);
			    ws.setColumnView(7, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(11, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(12, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(13, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(14, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(15, cell);
			
				wb.write();
				wb.close();
				return null;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try {

				response.setContentType("application/vnd.ms-excel");
				response.setHeader(
						"Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			
		
			
		} else if (billType.equals("dispensingDup")) {
			jasper = "BillDispensingsummary";
			parameters.put("billNo", billNo);
			parameters.put("loginname", loginName);
			parameters.put("Duplicate", Duplicate);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
		} else if (billType.equals("finalBillDup")) {
			jasper = "finalsettlementSummary";
			parameters.put("Duplicate", Duplicate);
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
		} else if (billType.equals("finalBillSettlementDup")) {
			jasper = "finalBillSettlementSummary";
			parameters.put("Duplicate", Duplicate);
			parameters.put("inpatientId", inpatientId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
		} else if (billType.equals("receiptDup")) {
			parameters.put("hospitalId", hospitalId);
			parameters.put("Duplicate", Duplicate);
			jasper = "Receipt";
			parameters.put("receiptNo", billNo);
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
		} else if (billType.equals("chargeSlipDup")) {
			parameters.put("hospitalId", hospitalId);
			parameters.put("Duplicate", Duplicate);
			parameters.put("billNo", Integer.parseInt(billNo));
			jasper = "ChargeSlip";
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
			
			
			
			
		} else if (billType.equals("refundsDup")) {
			parameters.put("Duplicate", Duplicate);
			parameters.put("refundno", billNo);
			parameters.put("hospitalId", hospitalId);
			jasper = "CashRefund";
			parameters.put("IMAGE_DIR",
					getServletContext().getRealPath("/jsp/images/svb.jpg"));
			parameters.put("IMAGE_DIR_LFT",
					getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
			parameters
					.put("IMAGE_VN_BHAVE",
							getServletContext().getRealPath(
									"/jsp/images/vn-bhave.jpg"));
		
		}
		
		
		

		/*
		 * if (!reportFile.exists()) throw new JRRuntimeException(
		 * "File jasper file not found. The report design must be compiled first."
		 * );
		 * 
		 * parameters.put("hospitalName", hospitalName);
		 * parameters.put("SUBREPORT_DIR"
		 * ,getServletContext().getRealPath("/Reports/"));
		 */

		Map<String, Object> connectionMap = generalMasterHandlerService
				.getConnection();

		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
		return null;
	}
	
	///-----------------------------Nikhil- Daily Excel Reports------------------     
	public ModelAndView generateDailyCashExcelReports(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();		
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		
		String reportName = "";
		String fromDate = null;
		String toDate = null;
		String hospitalName = "";
		int hospitalId = 1;
		String fromTime=null;
		String toTime=null;
		String fromDate1 = null;
		String toDate1 = null;
		String userId= null;
		String lastchgBy=null;

		File reportFile = null;
		String jasper = null;
		String loginName = "";
		String dailyReport="";
				
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);
		}
		if (request.getParameter(FROM_TIME) != null) {
			fromTime = request.getParameter(FROM_TIME);
		}	
		if (request.getParameter(TO_TIME) != null) {
			toTime = request.getParameter(TO_TIME);
		}
		
			jasper="DailyCashReport";
			parameters.put("fromDate1",
					HMSUtil.convertStringTypeDateToDateType(fromDate));
			parameters.put("toDate1",
					HMSUtil.convertStringTypeDateToDateType(toDate));
					
			parameters.put("fromTime1", fromTime);
			parameters.put("toTime1", toTime);
			parameters.put("hospital_name", hospitalName);
			parameters.put("hospitalId", hospitalId);
			parameters.put("userId", userId);
			parameters.put("lastchgBy", lastchgBy);
			
			Date date = new Date(fromDate);
			fromDate =  new SimpleDateFormat("yyyy-MM-dd").format(date);
			date = new Date(toDate);
			toDate =  new SimpleDateFormat("yyyy-MM-dd").format(date);
				
			String querydailyCashReport= " select maindata.* , (select hospital_name from mas_hospital where hospital_id = maindata.hospital_id) as hospitalname " + 
					" from  (select main.hospital_id, 'Billing' as billtype, main.changed_by ,  sum(main.chequeamount + main.creditcardamount + main.cashamount)  as tamt, " + 
					" sum(main.outstanding) as oamt, sum(main.charityamt) as camt, " + " sum(main.chequeamount) as chqamt, sum(main.creditcardamount) as crdamt, " + 
					" sum(main.cashamount) as chamt, " + "  main.receipt_date as receiptdate, " + " main.receipt_time as receiptime, main.brchangedname " + 
					" from (select bh.receipt_date, bh.receipt_time, bh.amount as totalamount, bh.changed_by, bh.hospital_id, " + 
					" (case when(select outstanding  from bl_op_bill_header  where op_bill_header_id = bh.op_bill_header_id) is null then 0 else " + 
					" (select outstanding  from bl_op_bill_header where op_bill_header_id = bh.op_bill_header_id) end) + case when (select outstanding  from bl_dispensing_header " + 
					" where dispensing_header_id = bh.dispensing_header_id) is null then 0 else " + " (select outstanding  from bl_dispensing_header " + 
					" where dispensing_header_id = bh.dispensing_header_id) end as outstanding, " + " case when bh.charity_amt is null then 0  else bh.charity_amt end as charityamt," + 
					" bd.payment_mode, " + "  case when bd.payment_mode='Q' then bd.amount  else '0' end as chequeamount, " + " case when bd.payment_mode='R' then bd.amount else 0 end as creditcardamount, " + 
					" case when bd.payment_mode='C' then bd.amount else 0 end as cashamount, " + " me.emp_name as brchangedname  from bl_receipt_header bh " + 
					" left outer join  bl_receipt_details bd  on bh.receipt_header_id = bd.receipt_header_id " + " left join users u on bh.changed_by = u.user_id " + 
					" left join mas_employee me on u.employee_id=me.employee_id " + " where receipt_type in ('opb', 'bld', 'chs')) as main " + 
					" where main.receipt_date between  '"+ fromDate +"' and  '"+ toDate +"'and main.receipt_time between  '"+ fromTime +"' and '"+ toTime +"' and main.hospital_id="+ hospitalId +
					" group by main.hospital_id,main.changed_by,main.receipt_date,main.receipt_time ,main.brchangedname " + 
					" union " + 
					" select main.hospital_id, " + "  'Receipt' as billtype, main.changed_by, " + " sum(main.chequeamount + main.creditcardamount + main.cashamount)  as tamt, " + 
					" sum(main.outstanding) as oamt,sum(main.charityamt) as camt, " + " sum(main.chequeamount) as chqamt, sum(main.creditcardamount) as crdamt, " + 
					" sum(main.cashamount) as chamt, " + " main.receipt_date as receiptdate,  " + " main.receipt_time as receipttime, " + " main.brchangedname " + 
					" from (select bh.amount as totalamount,bh.changed_by,bh.hospital_id, (case when (select outstanding  from bl_op_bill_header " + 
					" where op_bill_header_id = bh.op_bill_header_id) is null then 0 else " + " (select outstanding  from bl_op_bill_header where op_bill_header_id = bh.op_bill_header_id)end) + " + 
					" case when (select outstanding  from bl_dispensing_header where dispensing_header_id = bh.dispensing_header_id) is null then 0 else " + 
					" (select outstanding  from bl_dispensing_header where dispensing_header_id = bh.dispensing_header_id)end as outstanding, " + 
					" case when bh.charity_amt is null then 0 else bh.charity_amt end as charityamt, " + " bd.payment_mode, " + 
					" case when bd.payment_mode='Q' then bd.amount  else '0' end as chequeamount, " + " case when bd.payment_mode='R' then bd.amount else '0' end  as creditcardamount," + 
					" case when bd.payment_mode='C' then bd.amount else '0' end as cashamount, " + " bh.receipt_date, bh.receipt_time, " + " me.emp_name as brchangedname " + 
					" from bl_receipt_header bh  " + "  left outer join bl_receipt_details bd  on bh.receipt_header_id = bd.receipt_header_id " + " left join users u on u.user_id = bh.changed_by " + 
					" left join mas_employee me on u.employee_id=me.employee_id where receipt_type in ('adv' , 'fs' ) ) as main " + 
					" where main.receipt_date between  '"+ fromDate +"' and  '"+ toDate +"'and main.receipt_time between  '"+ fromTime +"' and  '"+ toTime +"'and main.hospital_id="+ hospitalId +
					" group by main.hospital_id,main.changed_by,main.receipt_date,main.receipt_time " + " ,main.brchangedname " + 
					" union " + 
					" select main.hospital_id, " + "  'Refund' as billtype, " + "  main.last_chg_by as changed_by, " + " sum(main.chequeamount + main.creditcardamount + main.cashamount)*(-1)  as tamt, " +
					" 0 as oamt,sum(main.charityamt)*(-1) as camt, " + " sum(main.chequeamount)*(-1) as chqamt, sum(main.creditcardamount) as crdamt, " + 
					" sum(main.cashamount)*(-1) as chamt , " + "  main.receiptdate,main.receipttime, " + "  main.brchangedname " + 
					" from (select rh.hospital_id, rh.refund_date as receiptdate,rh.refund_time as receipttime, rh.total_refund_amt,rh.last_chg_by, " + 
					" case when rh.charity_amt is null then 0 else rh.charity_amt end as charityamt, " + " rd.payment_mode, " + " case when rd.payment_mode='Q' then rd.refund_amount else '0' end as chequeamount, " + 
					" case when rd.payment_mode='C' then rd.refund_amount else '0' end as cashamount, " + " case when rd.payment_mode='R' then rd.refund_amount else '0' end as creditcardamount, " + 
					" me.emp_name as brchangedname " + " from bl_refund_header rh  " + "  left outer join bl_refund_details rd on rh.refund_header_id = rd.refund_header_id " + 
					" left join users u on rh.last_chg_by = u.user_id " + " left join mas_employee me on u.employee_id=me.employee_id) as main " + 
					" where main.receiptdate between  '"+ fromDate +"' and  '"+ toDate +"'and main.receipttime between  '"+ fromTime +"' and  '"+ toTime +"' and main.hospital_id="+ hospitalId +
					" group by hospital_id,main.last_chg_by,main.receiptdate,main.receipttime,main.brchangedname ) as maindata " + 
					" group by changed_by,billtype, " + "  maindata.hospital_id, " + "  maindata.tamt,maindata.oamt, " + " maindata.camt, " + " maindata.chqamt, " + "  maindata.crdamt, " + " maindata.chamt, " + " maindata.receiptdate," + 
					" maindata.receiptime,maindata.brchangedname " + "  order by maindata.brchangedname";

			
			
			
			List<Object[]> aList=new ArrayList<Object[]>();
		
			aList=generalMasterHandlerService.getDataForExcelReportDailyCash(querydailyCashReport);

			try{
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=DailyCashReport.xls");
				
				WritableWorkbook wb= Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws=wb.createSheet("Daily Cash Report", 0);
				ws.setProtected(true);
				
				WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);

				WritableFont wfForFooter = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				wfForFooter.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcForFooter = new WritableCellFormat(wfForFooter);
				wcForFooter.setAlignment(Alignment.CENTRE);
				
				WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
				wcf2.setShrinkToFit(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL,10);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
						
				if(session.getAttribute("hospitalName")!=null){
					hospitalName=""+session.getAttribute("hospitalName");
				}
				
				log.info("hospitalName "+hospitalName);
				ws.mergeCells(0,0,7,0);
				Label label = new Label(0,0,hospitalName,wcf);
				ws.addCell(label);

				ws.mergeCells(0,1,7,1);
				label = new Label(0,1,"Daily Cash Report ",wcf);
				ws.addCell(label);
				
				label = new Label(0,4,"From Date",wcf2);
				ws.addCell(label);
				label = new Label(1,4,fromDate,wcf3);
				ws.addCell(label);
				
				label = new Label(2,4,"To Date",wcf2);
				ws.addCell(label);
				label=new Label(3,4,toDate,wcf3);
				ws.addCell(label);
				
				label = new Label(4,4,"From Time",wcf2);
				ws.addCell(label);
				label=new Label(5,4,fromTime,wcf3);
				ws.addCell(label);
				
				label = new Label(6,4,"To Time",wcf2);
				ws.addCell(label);
				label = new Label(7,4,toTime,wcf3);
				ws.addCell(label);
				
				
				
				label = new Label(0,6,"Cashier",wcf2);
				ws.addCell(label);
				
				label = new Label(1,6,"Sr No. ",wcf2);
				ws.addCell(label);
				label = new Label(2,6,"Amount Type",wcf2);
				ws.addCell(label);
				label = new Label(3,6,"Cash Amount",wcf2);
				ws.addCell(label);
				label = new Label(4,6,"Cheque",wcf2);
				ws.addCell(label);
				label = new Label(5,6,"Credit Card",wcf2);
				ws.addCell(label);
				label = new Label(6,6,"A/C Amount",wcf2);
				ws.addCell(label);
				label = new Label(7,6,"Total Amount",wcf2);
				ws.addCell(label);
				

				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");
				String month=currentDate.substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				int slNo=1;
				if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
					slNo=31;
				}
				else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
					slNo=29;
				}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
					slNo=28;
				}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
					slNo=30;
				}
			int a=7;
			int a1=8;
		//	int a2=6;
			
			
			BigDecimal totalAmount=new BigDecimal(0);
			BigDecimal chqamt=new BigDecimal(0);
			BigDecimal cashamt=new BigDecimal(0);
			BigDecimal crdamt=new BigDecimal(0);
			BigDecimal acamt=new BigDecimal(0);
			BigDecimal tamt=new BigDecimal(0);
			
			BigDecimal ncashamt=new BigDecimal(0);
			BigDecimal nchqamt=new BigDecimal(0);
			BigDecimal ncrdamt=new BigDecimal(0);
			BigDecimal nacamt=new BigDecimal(0);
			BigDecimal namt=new BigDecimal(0);
			BigDecimal ntotalamt=new BigDecimal(0);
			BigDecimal discount=new BigDecimal(0);
	
			
			HashMap<Integer, Object> hashmap= new HashMap<Integer, Object>();
			int srNo=1;
			if (aList.size()>0) {
				for(Object[] obj1 : aList){
					
					 if(hashmap.get((Integer)obj1[2])==null){
					
						ws.mergeCells(0,a,7,a);
						label = new Label(0,a,""+obj1[11],wcf2);
						ws.addCell(label);
						
						log.info("Cashier........"+obj1[11]);
						
						for(Object[] obj :aList){
							
							if(obj1[2].equals(obj[2])){
										
								log.info("Data Field................."+srNo);
								
															
								label = new Label(1,a1,""+srNo,wcf3);
								ws.addCell(label);			
								label = new Label(2,a1,""+obj[1],wcf3);
								ws.addCell(label);
								label = new Label(3,a1,""+obj[8],wcf3);
								ws.addCell(label);
								label = new Label(4,a1,""+obj[6],wcf3);
								ws.addCell(label);
								label = new Label(5,a1,""+obj[7],wcf3);				
								ws.addCell(label);
								label = new Label(6,a1,""+obj[4],wcf3);
								ws.addCell(label);
											
								totalAmount=(new BigDecimal(""+obj[8])).add(new BigDecimal(""+obj[6])).add(new BigDecimal(""+obj[7])).add(new BigDecimal(""+obj[4]));
						
								label = new Label(7,a1,""+totalAmount,wcf3);
								ws.addCell(label);
								
													
								cashamt=cashamt.add(new BigDecimal(""+obj[8]));
								ncashamt=ncashamt.add(new BigDecimal(""+obj[8]));
								
								chqamt=chqamt.add(new BigDecimal(""+obj[6]));
								nchqamt=nchqamt.add(new BigDecimal(""+obj[6]));
								
								crdamt=crdamt.add(new BigDecimal(""+obj[7]));
								ncrdamt=ncrdamt.add(new BigDecimal(""+obj[7]));
								
								acamt=acamt.add(new BigDecimal(""+obj[4]));
								nacamt=nacamt.add(new BigDecimal(""+obj[4]));
											
								a1++;
								srNo++;	
								}
						
							
						
						} // end of inner loop 
						
					
						log.info("total Bill........"+obj1[2]);
				
						label = new Label(0,a1,"Total Amount",wcf2);
						ws.addCell(label);
						label = new Label(1,a1,"",wcf2);
						ws.addCell(label);
						label = new Label(2,a1,"",wcf2);
						ws.addCell(label);
						label = new Label(3,a1,""+cashamt,wcf2);
						ws.addCell(label);
						label = new Label(4,a1,""+chqamt,wcf2);
						ws.addCell(label);
						label = new Label(5,a1,""+crdamt,wcf2);
						ws.addCell(label);
						label = new Label(6,a1,""+acamt,wcf2);
						ws.addCell(label);
						tamt=cashamt.add(chqamt).add(crdamt).add(acamt);
						label = new Label(7,a1,""+tamt,wcf2);
						ws.addCell(label);
						
						a=a1+2;
						a1=a1+3;
						
						cashamt=new BigDecimal(0);
						chqamt=new BigDecimal(0);
						crdamt=new BigDecimal(0);
						acamt=new BigDecimal(0);
						srNo=1;
						
						 hashmap.put((Integer)obj1[2], obj1[2]);
						}
				
					}
						}
			
						a1=a1+2;
						label = new Label(0,a1,"net Total",wcf2);
						ws.addCell(label);
						label = new Label(1,a1,"",wcf2);
						ws.addCell(label);
						label = new Label(2,a1,"",wcf2);
						ws.addCell(label);
			
						label = new Label(3,a1,""+ncashamt,wcf2);
						ws.addCell(label);
						label = new Label(4,a1,""+nchqamt,wcf2);
						ws.addCell(label);
						label = new Label(5,a1,""+ncrdamt,wcf2);
						ws.addCell(label);
						label = new Label(6,a1,""+nacamt,wcf2);
						ws.addCell(label);
						ntotalamt=ncashamt.add(nchqamt).add(ncrdamt).add(nacamt);
						label = new Label(7,a1,""+ntotalamt,wcf2);
						ws.addCell(label);
						
						a1=a1+5;
						label = new Label(0,a1,currentDate,wcf2);
						ws.addCell(label);
						label = new Label(1,a1,time,wcf2);
						ws.addCell(label);
							
						
						CellView cell = new CellView();
					    cell.setSize(5000);
					    ws.setColumnView(0, cell);
					    cell.setSize(4000);
					    ws.setColumnView(1, cell);
					    cell.setSize(6000);
					    ws.setColumnView(2, cell);
					    cell.setSize(5000);
					    ws.setColumnView(3, cell);
					    cell.setSize(5000);
					    ws.setColumnView(4, cell);
					    cell.setSize(6000);
					    ws.setColumnView(5, cell);
					    cell.setSize(6000);
					    ws.setColumnView(6, cell);
					    cell.setSize(6000);
					    ws.setColumnView(7, cell);
					    
						wb.write();
						wb.close();
						return null;
						
					}catch(Exception e){
						
						e.printStackTrace();
					}
			
			try {
				
								response.setContentType("application/vnd.ms-excel");
								response.setHeader(
										"Content-Disposition",
										"attachment; filename="
												+ map.get("download_path").toString());
								File f = new File(map.get("download_path").toString());
								InputStream in = new FileInputStream(f);
								ServletOutputStream outs = response.getOutputStream();
								int bit = 256;
								int i = 0;
								while ((bit) >= 0) {
									bit = in.read();
									outs.write(bit);
								}
								outs.flush();
								outs.close();
								in.close();
								if (f.exists())
									f.delete();
							} catch (IOException ioe) {
								ioe.printStackTrace();
				
			}
			return null;

	}
	
	///-----------------------------Nikhil- Cash Collection Report Reports------------------     
		public ModelAndView generateCashCollectionReports(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session = request.getSession();		
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			
			String reportName = "";
			String fromDate = null;
			String toDate = null;
			String deptName="";
			String hospitalName = "";
			int hospitalId = 1;
			
			File reportFile = null;
			String jasper = null;
			String loginName = "";
			String dailyReport="";
					
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);
			}
			
			if(session.getAttribute("deptName")!=null){
				
				deptName = ""+session.getAttribute("deptName");
			}
			
						
				jasper="DailyCashReport";
				parameters.put("fromDate1",
						HMSUtil.convertStringTypeDateToDateType(fromDate));
				parameters.put("toDate1",
						HMSUtil.convertStringTypeDateToDateType(toDate));
						
				parameters.put("hospital_name", hospitalName);
				parameters.put("hospitalId", hospitalId);
				parameters.put("department_Name", deptName);
				
				Date date = new Date(fromDate);
				fromDate =  new SimpleDateFormat("yyyy-MM-dd").format(date);
				date = new Date(toDate);
				toDate =  new SimpleDateFormat("yyyy-MM-dd").format(date);
					
				String queryCashCollectionReport= "SELECT  patient_name, "  +  " bill_no, bill_date, " +  " bill_amt, " + "COALESCE(discount_amt,0) AS discount_amt," +
								"COALESCE(net_amt,bill_amt-COALESCE(discount_amt,0))AS net_amt FROM bl_dispensing_header b WHERE Bill_Date BETWEEN '"+ fromDate +"' AND '" + toDate +" '" ;
				
				
			
				
				
				List<Object[]> aList=new ArrayList<Object[]>();
				aList=generalMasterHandlerService.getDataForCashCollectionReport(queryCashCollectionReport);
				
		
				
			
				try{
					response.setContentType("application/vnd.ms-excel");
					response.setHeader("Content-Disposition","attachment; filename=CashCollectionReport.xls");
					
					WritableWorkbook wb= Workbook.createWorkbook(response.getOutputStream());
					WritableSheet ws=wb.createSheet("CashCollectionReport", 0);
					ws.setProtected(true);
					
					WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
					wf.setUnderlineStyle(UnderlineStyle.SINGLE);
					WritableCellFormat wcf = new WritableCellFormat(wf);
					wcf.setAlignment(Alignment.CENTRE);

					WritableFont wfForFooter = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
					wfForFooter.setUnderlineStyle(UnderlineStyle.SINGLE);
					WritableCellFormat wcForFooter = new WritableCellFormat(wfForFooter);
					wcForFooter.setAlignment(Alignment.CENTRE);
					
					WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
					WritableCellFormat wcf2 = new WritableCellFormat(wf2);
					wcf2.setShrinkToFit(true);
					wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
					wcf2.setVerticalAlignment(VerticalAlignment.TOP);
					
					WritableFont wf3 = new WritableFont(WritableFont.ARIAL,10);
					WritableCellFormat wcf3 = new WritableCellFormat(wf3);
					wcf3.setWrap(true);
					wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
							
					if(session.getAttribute("hospitalName")!=null){
						hospitalName=""+session.getAttribute("hospitalName");
					}
										
					log.info("hospitalName ---"+hospitalName);
					ws.mergeCells(0,0,6,0);
					Label label = new Label(0,0,hospitalName,wcf);
					ws.addCell(label);
					
					ws.mergeCells(0,1,6,1);
					label = new Label(0,1,"Cash Collection Report ",wcf);
					ws.addCell(label);
					
					label = new Label(0,3,"Locatio",wcf2);
					ws.addCell(label);
					label = new Label(1,3,deptName,wcf3);
					ws.addCell(label);
					
					label = new Label(1,4,"From Date",wcf2);
					ws.addCell(label);
					label = new Label(2,4,fromDate,wcf3);
					ws.addCell(label);
					
					label = new Label(4,4,"To Date",wcf2);
					ws.addCell(label);
					label = new Label(5,4,toDate,wcf3);
					ws.addCell(label);
												
					label = new Label(0,6,"Sr No. ",wcf2);
					ws.addCell(label);
					label = new Label(1,6,"Patient Name ",wcf2);
					ws.addCell(label);
					label = new Label(2,6,"Bill No.",wcf2);
					ws.addCell(label);
					label = new Label(3,6,"Bill Date",wcf2);
					ws.addCell(label);
					label = new Label(4,6,"Bill Amt.",wcf2);
					ws.addCell(label);
					label = new Label(5,6,"Dis. Amt.",wcf2);
					ws.addCell(label);
					label = new Label(6,6,"Net Amount",wcf2);
					ws.addCell(label);
									

					Map<String,Object> utilMap = new HashMap<String,Object>();
					utilMap = (Map)HMSUtil.getCurrentDateAndTime();
					String currentDate = (String)utilMap.get("currentDate");
					String time = (String)utilMap.get("currentTime");
					String month=currentDate.substring(3,5);
					String monthName=HMSUtil.getMonthName(month);
					int slNo=1;
					if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
						slNo=31;
					}
					else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
						slNo=29;
					}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
						slNo=28;
					}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
						slNo=30;
					}
					
				int a=7;
				int a1=4;	
				
				BigDecimal totalAmount=new BigDecimal(0);
				BigDecimal netamt=new BigDecimal(0);
			//	BigDecimal billamt=new BigDecimal(0);
				BigDecimal disamt=new BigDecimal(0);
				BigDecimal tbillamt=new BigDecimal(0);
				BigDecimal tdisamt=new BigDecimal(0);
				
				int srNo=1;
				if (aList.size()>0) {
					
					for(Object[] obj : aList){
						
						
			//			if(aList.size()>0){
							
						label = new Label(0,a,""+srNo,wcf3);
						ws.addCell(label);
						label = new Label(1,a,""+obj[0],wcf3);
						ws.addCell(label);
						label = new Label(2,a,""+obj[1],wcf3);
						ws.addCell(label);
						label = new Label(3,a,""+obj[2],wcf3);
						ws.addCell(label);
						label = new Label(4,a,""+obj[3],wcf3);
						ws.addCell(label);
						label = new Label(5,a,""+obj[4],wcf3);
						ws.addCell(label);
						
						BigDecimal billamt = new BigDecimal(""+obj[3]);
						netamt = billamt.subtract(new BigDecimal(""+obj[4]));
						label = new Label(6,a,""+netamt,wcf3);
						ws.addCell(label);
						
						
						
			 			totalAmount=totalAmount.add(new BigDecimal(""+obj[5]));
			 			tbillamt=tbillamt.add(new BigDecimal(""+obj[3]));
			 			tdisamt=tdisamt.add(new BigDecimal(""+obj[4]));
			 			
					//	disamt=disamt.add(new BigDecimal(""+obj[4]));
						
						a++;
						srNo++;
					}
					}
				
					a1=a+2;
					label = new Label(3,a1,"Total Amount",wcf2);
					ws.addCell(label);
					label = new Label(4,a1,""+tbillamt,wcf2);
					ws.addCell(label);
					label = new Label(5,a1,""+tdisamt,wcf2);
					ws.addCell(label);
					label = new Label(6,a1,""+totalAmount,wcf2);
					ws.addCell(label);
					
					a1=a+5;
					label = new Label(0,a1,currentDate,wcf2);
					ws.addCell(label);
					label = new Label(1,a1,time,wcf2);
					ws.addCell(label);
					
					
					CellView cell = new CellView();
				    cell.setSize(3000);
				    ws.setColumnView(0, cell);
				    cell.setSize(9000);
				    ws.setColumnView(1, cell);
				    cell.setSize(4000);
				    ws.setColumnView(2, cell);
				    cell.setSize(5000);
				    ws.setColumnView(3, cell);
				    cell.setSize(5000);
				    ws.setColumnView(4, cell);
				    cell.setSize(6000);
				    ws.setColumnView(5, cell);
				    cell.setSize(6000);
				    ws.setColumnView(6, cell);
				    cell.setSize(6000);
				    ws.setColumnView(7, cell);
				    
				   	wb.write();
					wb.close();
					return null;
				
				}catch(Exception e){
					
					e.printStackTrace();
				}
				
				try {
					
									response.setContentType("application/vnd.ms-excel");
									response.setHeader(
											"Content-Disposition",
											"attachment; filename="
													+ map.get("download_path").toString());
									File f = new File(map.get("download_path").toString());
									InputStream in = new FileInputStream(f);
									ServletOutputStream outs = response.getOutputStream();
									int bit = 256;
									int i = 0;
									while ((bit) >= 0) {
										bit = in.read();
										outs.write(bit);
									}
									outs.flush();
									outs.close();
									in.close();
									if (f.exists())
										f.delete();
								} catch (IOException ioe) {
									ioe.printStackTrace();
					
				}
				return null;
			
		}
		
		
		

	/*
	 * public ModelAndView generateReportForGeneralMasters( HttpServletRequest
	 * request, HttpServletResponse response) { HttpSession session =
	 * request.getSession(); Map<String, Object> mapResponse = new
	 * HashMap<String, Object>(); Map<String, Object> mapForDs = new
	 * HashMap<String, Object>(); List<MasHospital> masHospitaList = new
	 * ArrayList<MasHospital>(); int hospitalId = 0; String hospitalName = "";
	 * String jasper = null; if (request.getParameter(JASPER_FILE_NAME) != null)
	 * { jasper = request.getParameter(JASPER_FILE_NAME); } if
	 * (session.getAttribute("hospitalId") != null) { hospitalId = (Integer)
	 * session.getAttribute("hospitalId"); mapForDs.put("hospitalId",
	 * hospitalId); mapResponse =
	 * generalMasterHandlerService.getHospitalName(mapForDs); }
	 * 
	 * if (mapResponse.get("masHospitaList") != null) { masHospitaList = (List)
	 * mapResponse.get("masHospitaList"); hospitalName =
	 * masHospitaList.get(0).getHospitalName();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * Map<String, Object> parameters = new HashMap<String, Object>(); //
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * parameters.put("hospitalName", hospitalName);
	 * parameters.put("SUBREPORT_DIR",
	 * getServletContext().getRealPath("/Reports/")); Map<String, Object>
	 * connectionMap = generalMasterHandlerService .getConnection(); log.debug(
	 * "parameters.get(conn)==== " + connectionMap.get("conn"));
	 * HMSUtil.generateReport(jasper, parameters, (Connection)
	 * connectionMap.get("conn"), response, getServletContext()); return null; }
	 */

	// -------------------------------- Village
	// ------------------------------------------

	private Map<String, Object> getHospitalParameterDetails(
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showVillageJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showVillage();
		String jsp = VILLAGE;
		jsp += ".jsp";
		title = "village";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addVillage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasVillage masVillage = new MasVillage();
		int postcodeId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		int talukId = 0;

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

			if (request.getParameter("talukId") != null
					&& !(request.getParameter("talukId").equals("0"))) {
				talukId = Integer.parseInt(request.getParameter("talukId"));
			}

			if (request.getParameter(POST_CODE_ID) != null
					&& !(request.getParameter(POST_CODE_ID).equals("0"))) {
				postcodeId = Integer.parseInt(request
						.getParameter(POST_CODE_ID));
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
		List villageCodeList = new ArrayList();
		List villageNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			villageCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			villageNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((villageCodeList.size() == 0 || villageCodeList == null)
				&& (villageNameList.size() == 0 || villageNameList == null)) {
			masVillage.setVillageCode(code);
			masVillage.setVillageName(name);

			/*
			 * MasPostCode masPostCode = new MasPostCode();
			 * masPostCode.setId(postcodeId);
			 * masVillage.setPostCode(masPostCode); masVillage.setStatus("Y")
			 */;

			Users users = new Users();
			users.setId(userId);
			masVillage.setLastChgBy(users);

			/*
			 * MasHospital basicSection= new MasHospital();
			 * basicSection.setId(hospitalId);
			 * masVillage.setBasicSection(basicSection);
			 */

			MasTaluk masTaluk = new MasTaluk();
			masTaluk.setId(talukId);
			masVillage.setTaluk(masTaluk);
			masVillage.setStatus("Y");
			masVillage.setLastChgDate(currentDate);
			masVillage.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addVillage(masVillage);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((villageCodeList.size() != 0 || villageCodeList != null)
				|| (villageNameList.size() != 0) || villageNameList != null) {
			if ((villageCodeList.size() != 0 || villageCodeList != null)
					&& (villageNameList.size() == 0 || villageNameList == null)) {
				message = "Village Code already exists.";
			} else if ((villageNameList.size() != 0 || villageNameList != null)
					&& (villageCodeList.size() == 0 || villageCodeList == null)) {
				message = "Village Name already exists.";
			} else if ((villageCodeList.size() != 0 || villageCodeList != null)
					&& (villageCodeList.size() != 0 || villageNameList != null)) {
				message = "Village Code and Name exist.";
			}
		}
		try {
			map = generalMasterHandlerService.showVillage();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// jsp=VILLAGE_JSP;
		// title="Add Village";
		// jsp += ".jsp";

		String jsp = VILLAGE;
		title = " Add village";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editVillage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String villageCode = "";
		String villageName = "";
		int postcodeId = 0;
		int talukId = 0;
		int villageId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		int hospitalId = 0;

		try {
			if (request.getParameter(POST_CODE_ID) != null
					&& !(request.getParameter(POST_CODE_ID).equals("0"))) {
				postcodeId = Integer.parseInt(request
						.getParameter(POST_CODE_ID));
			}
			if (request.getParameter(HOSPITAL_ID) != null
					&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
				hospitalId = Integer
						.parseInt(request.getParameter(HOSPITAL_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				villageId = Integer.parseInt(request.getParameter(COMMON_ID));
			}

			if (request.getParameter("talukId") != null
					&& !(request.getParameter("talukId").equals("0"))) {
				talukId = Integer.parseInt(request.getParameter("talukId"));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				villageCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				villageName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", villageId);
			generalMap.put("villageCode", villageCode);
			generalMap.put("name", villageName);
			generalMap.put("postcodeId", postcodeId);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("talukId", talukId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			Map<String, Object> listMap = new HashMap<String, Object>();

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingVillageNameList = (List) listMap
					.get("duplicateMastersList");
			boolean dataUpdated = false;

			if (existingVillageNameList.size() == 0) {
				dataUpdated = generalMasterHandlerService
						.editVillage(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingVillageNameList.size() > 0) {
				message = "Name already exists.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			map = generalMasterHandlerService.showVillage();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// jsp=VILLAGE_JSP;
		// title="Edit Village";
		// jsp += ".jsp";

		String jsp = VILLAGE;
		title = " Edit village";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchVillage(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String villageCode = null;
		String villageName = null;
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
			villageCode = searchField;
			villageName = null;

		} else {
			villageCode = null;
			villageName = searchField;
		}

		//

		map = generalMasterHandlerService.searchVillage(villageCode,
				villageName);

		jsp = VILLAGE;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("villageCode", villageCode);
		map.put("villageName", villageName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteVillage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int villageId = 0;
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
			villageId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteVillage(villageId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showVillageJsp";
		try {
			map = generalMasterHandlerService.showVillage();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = VILLAGE;
		title = "delete Village";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------ Company Master-----------------------

	public ModelAndView showCompanyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		map = generalMasterHandlerService.showCompanyJsp();
		jsp = "company.jsp";
		title = "Company";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchCompany(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String companyCode = "";
		String companyName = "";
		String searchField = "";

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			companyCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			companyName = request.getParameter(SEARCH_NAME);
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
			companyCode = searchField;
			companyName = null;

		} else {
			companyCode = null;
			companyName = searchField;
		}
		map = generalMasterHandlerService.searchCompany(companyCode,
				companyName);
		jsp = "company.jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("companyCode", companyCode);
		map.put("companyName", companyName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCompanyDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasCompany masCompany = new MasCompany();
		int changedBy = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (session.getAttribute("userId") != null)
			changedBy = Integer.parseInt("" + session.getAttribute("userId"));

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

		List companyCodeList = new ArrayList();
		List companyNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			companyCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			companyNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((companyCodeList.size() == 0 || companyCodeList == null)
				&& (companyNameList.size() == 0 || companyNameList == null)) {
			masCompany.setCompanyCode(code);
			masCompany.setCompanyName(name);
			if (!request.getParameter("companyType").equals("0")) {
				int companyType = (Integer.parseInt(request
						.getParameter("companyType")));
				MasPatientType patientType = new MasPatientType();
				patientType.setId(companyType);
				masCompany.setPatientType(patientType);
			}
			if (request.getParameter(CONTACT_PERSON) != null) {
				masCompany.setContactPerson(request
						.getParameter(CONTACT_PERSON));
			}
			if (request.getParameter(CONTACT_NUMBER) != null) {
				masCompany.setContactNo(request.getParameter(CONTACT_NUMBER));
			}
			if (request.getParameter(ADDRESS) != null) {
				masCompany.setAddress(request.getParameter(ADDRESS));
			}
			if (request.getParameter("coordinatorCode") != null) {
				masCompany.setCoordinatorCode(request
						.getParameter("coordinatorCode"));
			}
			if (request.getParameter("companyType") != null) {
				masCompany.setCompanyType(request.getParameter("companyType"));
			}

			masCompany.setStatus("y");
			Users user = new Users();
			user.setId(changedBy);
			masCompany.setLastChgBy(user);
			masCompany.setLastChgDate(currentDate);
			masCompany.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addCompanyDetails(masCompany);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((companyCodeList.size() != 0 || companyCodeList != null)
				|| (companyNameList.size() != 0) || companyNameList != null) {
			if ((companyCodeList.size() != 0 || companyCodeList != null)
					&& (companyNameList.size() == 0 || companyNameList == null)) {
				message = "Company Code  already exists.";
			} else if ((companyNameList.size() != 0 || companyNameList != null)
					&& (companyCodeList.size() == 0 || companyCodeList == null)) {
				message = "Company Name already exists.";
			} else if ((companyCodeList.size() != 0 || companyCodeList != null)
					&& (companyNameList.size() != 0 || companyNameList != null)) {
				message = "Company Code and Company Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showCompanyJsp";
		try {
			map = generalMasterHandlerService.showCompanyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "company.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateCompanyDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String companyCode = "";
		String companyName = "";
		int companyId = 0;
		int changedBy = 0;
		Date changedDate = new Date();
		String changedTime = "";
		if (session.getAttribute("userId") != null)
			changedBy = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			companyId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			companyCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			companyName = request.getParameter(SEARCH_NAME);
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
		log.debug("request.getParameter(companyType)------ "
				+ request.getParameter("companyType"));
		if (!request.getParameter("companyType").equals("0")) {
			int companyType = (Integer.parseInt(request
					.getParameter("companyType")));
			generalMap.put("companyType", companyType);
		}
		if (request.getParameter(CONTACT_PERSON) != null) {
			generalMap.put("contactPerson",
					request.getParameter(CONTACT_PERSON));
		}
		if (request.getParameter(CONTACT_NUMBER) != null) {
			generalMap.put("contactNo", request.getParameter(CONTACT_NUMBER));
		}
		if (request.getParameter(ADDRESS) != null) {
			generalMap.put("address", request.getParameter(ADDRESS));
		}
		if (request.getParameter("coordinatorCode") != null) {
			generalMap.put("coordinatorCode",
					request.getParameter("coordinatorCode"));
		}
		if (request.getParameter("companyType") != null) {
			generalMap.put("companyType",
					Integer.parseInt(request.getParameter("companyType")));
		}

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		generalMap.put("id", companyId);
		generalMap.put("relationCode", companyCode);
		generalMap.put("name", companyName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCompanyNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCompanyNameList.size() == 0) {

			dataUpdated = generalMasterHandlerService
					.updateCompanyDetails(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCompanyNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showCompanyJsp";
		try {
			map = generalMasterHandlerService.showCompanyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "company.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteCompany(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int companyId = 0;
		String message = null;
		int changedBy = 0;
		if (session.getAttribute("userId") != null)
			changedBy = Integer.parseInt("" + session.getAttribute("userId"));

		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			companyId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteCompany(companyId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCompanyJsp";
		try {
			map = generalMasterHandlerService.showCompanyJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "company.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBranchMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = generalMasterHandlerService.showBranchMasterJsp();
		jsp = "branch.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addBranch(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasBranch masBranch = new MasBranch();
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
		int departmentId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
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
		generalMap.put("departmentId", departmentId);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List branchCodeList = new ArrayList();
		List branchNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			branchCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			branchNameList = (List) listMap.get("duplicateGeneralNameList");
		}

		Users users = new Users();
		HttpSession session = request.getSession();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
		}
		boolean successfullyAdded = false;

		if ((branchCodeList.size() == 0 || branchNameList == null)
				&& (branchNameList.size() == 0 || branchNameList == null)) {
			masBranch.setBranchCode(code);
			masBranch.setBranchDesc(name);
			masBranch.setStatus("y");
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masBranch.setDepartment(masDepartment);
			// users.setId(changedBy);
			masBranch.setLastChgBy("admin");
			masBranch.setLastChgDate(currentDate);
			masBranch.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addBranch(masBranch);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((branchCodeList.size() != 0 || branchCodeList != null)
				|| (branchNameList.size() != 0) || branchNameList != null) {
			if ((branchCodeList.size() != 0 || branchCodeList != null)
					&& (branchNameList.size() == 0 || branchNameList == null)) {

				message = "Branch Code  already exists.";
			} else if ((branchNameList.size() != 0 || branchNameList != null)
					&& (branchCodeList.size() == 0 || branchCodeList == null)) {

				message = "Branch Name already exists.";
			} else if ((branchCodeList.size() != 0 || branchCodeList != null)
					&& (branchNameList.size() != 0 || branchNameList != null)) {

				message = "Branch Code and Branch Name already exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showBranchMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "branch.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBranch(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String branchCode = "";
		String branchName = "";
		int branchId = 0;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			branchId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			branchCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			branchName = request.getParameter(SEARCH_NAME);
		}
		int departmentId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		Users users = new Users();

		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
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

		generalMap.put("id", branchId);
		generalMap.put("titleCode", branchCode);
		generalMap.put("name", branchName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("departmentId", departmentId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBranchNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBranchNameList.size() == 0) {

			dataUpdated = generalMasterHandlerService.editBranch(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBranchNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showBranchMasterJsp";

		try {
			map = generalMasterHandlerService.showBranchMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "branch.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBranch(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int branchId = 0;
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
			branchId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteBranch(branchId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showBranchMasterJsp";
		try {
			map = generalMasterHandlerService.showBranchMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "branch.jsp";
		title = "delete Village";
		// jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReceipt(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();

		File reportFile = null;
		int hospitalId = 0;
		String jasper = null;
		String hospitalName = "";
		String hinNo = "";
		String loginName = "";
		String billType = "";
		String Duplicate = "Duplicate";
		int inpatientId = 0;

		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		/*
		 * if(request.getParameter("loginName") != null){ loginName =
		 * request.getParameter("loginName"); }
		 * if(request.getParameter("billtype") != null){ billType =
		 * request.getParameter("billtype"); }
		 * if(request.getParameter("inpatientId") != null){ inpatientId =
		 * Integer.parseInt(request.getParameter("inpatientId")); }
		 */

		/*
		 * if (session.getAttribute("hospitalId") != null) { hospitalId =
		 * (Integer) session.getAttribute("hospitalId");
		 * mapForDs.put("hospitalId", hospitalId); mapResponse =
		 * generalMasterHandlerService.getHospitalName(mapForDs); }
		 * 
		 * if (mapResponse.get("masHospitaList") != null) { masHospitaList =
		 * (List) mapResponse.get("masHospitaList"); hospitalName =
		 * masHospitaList.get(0).getHospitalName();
		 * 
		 * }
		 * 
		 * if (request.getParameter(JASPER_FILE_NAME) != null) { jasper =
		 * request.getParameter(JASPER_FILE_NAME); }
		 */

		jasper = "ReceiptForFreePatient";
		parameters.put("hinNo", hinNo);
		parameters.put("IMAGE_DIR",
				getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT",
				getServletContext().getRealPath("/jsp/images/svbLft.jpg"));
		parameters.put("IMAGE_VN_BHAVE",
				getServletContext().getRealPath("/jsp/images/vn-bhave.jpg"));

		/*
		 * if (!reportFile.exists()) throw new JRRuntimeException(
		 * "File jasper file not found. The report design must be compiled first."
		 * );
		 * 
		 * parameters.put("hospitalName", hospitalName);
		 * parameters.put("SUBREPORT_DIR"
		 * ,getServletContext().getRealPath("/Reports/"));
		 */

		Map<String, Object> connectionMap = generalMasterHandlerService
				.getConnection();

		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
		return null;
	}

	// ------------------------------------------Grade
	// ----------------------------------

	public ModelAndView searchGrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String gradeCode = null;

		if (request.getParameter("searchField") != null
				&& !(request.getParameter("searchField").equals("searchField"))) {
			gradeCode = request.getParameter("searchField");
		}
		map = generalMasterHandlerService.searchGrade(gradeCode);
		jsp = "grade";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("gradeCode", gradeCode);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showGradeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = generalMasterHandlerService.showGradeJsp();
		String jsp = "grade";
		jsp += ".jsp";
		title = "Unit";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addGrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasGrade masGrade = new MasGrade();
		String payScaleCode = "";
		String gradeLevel = "";
		String remarks = "";
		Date startDate = new Date();
		Date endDate = new Date();
		String gradeCode = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter("payScaleCode") != null) {
			payScaleCode = request.getParameter("payScaleCode");
		}
		if (request.getParameter(CODE) != null) {
			gradeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			gradeLevel = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("remarks") != null
				&& !(request.getParameter("remarks").equals(""))) {
			remarks = request.getParameter("remarks");
		}

		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {
			startDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));
		}
		if (request.getParameter(END_DATE) != null
				&& !(request.getParameter(END_DATE).equals(""))) {
			endDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE));
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

		generalMap.put("code", gradeCode);
		generalMap.put("payScaleCode", payScaleCode);
		generalMap.put("name", gradeLevel);
		generalMap.put("startDate", startDate);
		generalMap.put("endDate", endDate);
		generalMap.put("remarks", remarks);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List gradeCodeList = new ArrayList();
		List gradeLevelList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			gradeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			gradeLevelList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((gradeCodeList.size() == 0 || gradeCodeList == null)
				&& (gradeLevelList.size() == 0 || gradeLevelList == null)) {

			masGrade.setGradeCode(gradeCode);
			masGrade.setStatus("Y");
			masGrade.setPayScaleCode(payScaleCode);
			masGrade.setGradeLevel(gradeLevel);
			masGrade.setStartDate(startDate);
			masGrade.setEndDate(endDate);
			masGrade.setRemarks(remarks);
			Users users = new Users();
			users.setId(userId);
			masGrade.setLastChgBy(users);

			masGrade.setLastChgDate(currentDate);
			masGrade.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addGrade(masGrade);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((gradeCodeList.size() != 0 || gradeCodeList != null)
				|| (gradeLevelList.size() != 0) || gradeLevelList != null) {
			if ((gradeCodeList.size() != 0 || gradeCodeList != null)
					&& (gradeLevelList.size() == 0 || gradeLevelList == null)) {

				message = "Grade Code  already exists.";
			} else if ((gradeLevelList.size() != 0 || gradeLevelList != null)
					&& (gradeCodeList.size() == 0 || gradeCodeList == null)) {

				message = "Grade Level already exists.";
			} else if ((gradeCodeList.size() != 0 || gradeCodeList != null)
					&& (gradeLevelList.size() != 0 || gradeLevelList != null)) {

				message = "Grade Code Code and Grade Level already exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showGradeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "grade";
		title = "Add Grade";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editGrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		MasGrade masGrade = new MasGrade();
		session = request.getSession();
		String payScaleCode = "";
		String gradeLevel = "";
		String remarks = "";
		Date startDate = new Date();
		Date endDate = new Date();
		int gradeId = 0;
		String gradeCode = "";
		Date changedDate = null;
		String changedTime = "";

		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			gradeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("payScaleCode") != null) {
			payScaleCode = request.getParameter("payScaleCode");
		}
		if (request.getParameter(CODE) != null) {
			gradeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			gradeLevel = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("remarks") != null
				&& !(request.getParameter("remarks").equals(""))) {
			remarks = request.getParameter("remarks");
		}

		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {
			startDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));
		}
		if (request.getParameter(END_DATE) != null
				&& !(request.getParameter(END_DATE).equals(""))) {
			endDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE));
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

		generalMap.put("id", gradeId);
		generalMap.put("startDate", startDate);
		generalMap.put("endDate", endDate);
		generalMap.put("payScaleCode", payScaleCode);
		generalMap.put("gradeCode", gradeCode);
		generalMap.put("remarks", remarks);
		generalMap.put("name", gradeLevel);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingGradeLevelList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingGradeLevelList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editGradeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingGradeLevelList.size() > 0) {
			message = "Grade Level already exists.";
		}

		url = "/hms/hms/generalMaster?method=showGradeJsp";

		try {
			map = generalMasterHandlerService.showGradeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "grade";
		title = "update Grade";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteGrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int gradeId = 0;
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
			gradeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteGrade(gradeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showGradeJsp";

		try {
			map = generalMasterHandlerService.showGradeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "grade";
		title = "delete Grade";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Stream
	// ----------------------------------

	public ModelAndView searchStream(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String streamName = null;

		if (request.getParameter("searchField") != null
				&& !(request.getParameter("searchField").equals(""))) {
			streamName = request.getParameter("searchField");
		}
		map = generalMasterHandlerService.searchStream(streamName);
		jsp = "stream";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("streamName", streamName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showStreamJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = generalMasterHandlerService.showStreamJsp();
		String jsp = "stream";
		jsp += ".jsp";
		title = "Stream";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addStream(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStream masStream = new MasStream();
		String description = "";
		String streamName = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter("description") != null && !request.getParameter("description").equals("")) {
			description = request.getParameter("description");
		}
		if (request.getParameter(SEARCH_NAME) != null && !request.getParameter(SEARCH_NAME).equals("")) {
			streamName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("name", streamName);
		generalMap.put("des", description);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List streamNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			streamNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((streamNameList.size() == 0 || streamNameList == null)
				&& (streamNameList.size() == 0 || streamNameList == null)) {
			masStream.setStreamName(streamName);
			masStream.setStatus("Y");
			masStream.setDescription(description);

			Users users = new Users();
			users.setId(userId);
			masStream.setLastChgBy(users);

			masStream.setLastChgDate(currentDate);
			masStream.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addStream(masStream);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((streamNameList.size() != 0) || streamNameList != null) {
			if ((streamNameList.size() != 0 || streamNameList != null)) {
				message = "Stream Name already exists.";
			}
		}
		try {
			map = generalMasterHandlerService.showStreamJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "stream";
		title = "Add Stream";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editStream(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String description = "";
		String streamName = "";
		int streamId = 0;
		Date changedDate = null;
		String changedTime = "";

		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			streamId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("description") != null && !request.getParameter("description").equals("")) {
			description = request.getParameter("description");
		}
		if (request.getParameter(SEARCH_NAME) != null && !request.getParameter(SEARCH_NAME).equals("")) {
			streamName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", streamId);
		generalMap.put("des", description);
		generalMap.put("name", streamName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingStreamNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingStreamNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editStreamToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingStreamNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showStreamJsp";

		try {
			map = generalMasterHandlerService.showStreamJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "stream";
		title = "update Stream";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteStream(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int streamId = 0;
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
			streamId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteStream(streamId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showStreamJsp";

		try {
			map = generalMasterHandlerService.showStreamJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "stream";
		title = "delete Stream";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Cadre
	// ----------------------------------

	public ModelAndView searchCadre(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String cadreName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			cadreName = request.getParameter(SEARCH_NAME);
		}
		map = generalMasterHandlerService.searchCadre(cadreName);
		jsp = "cadre";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("cadreName", cadreName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showCadreJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = generalMasterHandlerService.showCadreJsp();
		String jsp = "cadre";
		jsp += ".jsp";
		title = "Cadre";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCadre(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasCadre masCadre = new MasCadre();
		String description = "";
		String cadreName = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId = 0;
		int strength = 0;
		// int permaPost = 0;
		// int tempPost = 0;
		// int supernumPost = 0;

		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter("strength") != null && !request.getParameter("strength").equals("")) {
			strength = Integer.parseInt(request.getParameter("strength"));
		}
		if (request.getParameter("description") != null && !request.getParameter("description").equals("")) {
			description = request.getParameter("description");
		}

		/*
		 * if (request.getParameter("permaPost") != null) { permaPost =
		 * Integer.parseInt(request.getParameter("permaPost")); } if
		 * (request.getParameter("tempPost") != null) { tempPost =
		 * Integer.parseInt(request.getParameter("tempPost")); }
		 * 
		 * if (request.getParameter("supernumPost") != null) { supernumPost =
		 * Integer.parseInt(request .getParameter("supernumPost")); }
		 */

		if (request.getParameter(SEARCH_NAME) != null && !request.getParameter(SEARCH_NAME).equals("")) {
			cadreName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("name", cadreName);
		generalMap.put("des", description);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List cadreNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			cadreNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((cadreNameList.size() == 0 || cadreNameList == null)
				&& (cadreNameList.size() == 0 || cadreNameList == null)) {
			masCadre.setCadreName(cadreName);
			masCadre.setStatus("y");
			masCadre.setCadreStrength(strength);
			// masCadre.setPermanentPost(permaPost);
			// masCadre.setTempPost(tempPost);
			// masCadre.setSupernumeraryPost(supernumPost);

			Users users = new Users();
			users.setId(userId);
			masCadre.setLastChgBy(users);
			masCadre.setDescription(description);

			masCadre.setLastChgDate(currentDate);
			masCadre.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addCadre(masCadre);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((cadreNameList.size() != 0) || cadreNameList != null) {
			if ((cadreNameList.size() != 0 || cadreNameList != null)) {
				message = "Cadre Name already exists.";
			}
		}
		try {
			map = generalMasterHandlerService.showCadreJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "cadre";
		title = "Add Cadre";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editCadre(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String description = "";
		String cadreName = "";
		int cadreId = 0;
		int strength = 0;
		// int permaPost = 0;
		// int tempPost = 0;
		// int supernumPost = 0;
		Date changedDate = null;
		String changedTime = "";

		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			cadreId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("description") != null && !request.getParameter("description").equals("")) {
			description = request.getParameter("description");
		}
		if (request.getParameter("strength") != null && !request.getParameter("strength").equals("")) {
			String str = request.getParameter("strength").trim();
			strength = Integer.parseInt(str);
		}
		/*
		 * if (request.getParameter("permaPost") != null &&
		 * !request.getParameter("permaPost").equals("")) { String
		 * str=request.getParameter("permaPost").trim(); permaPost =
		 * Integer.parseInt(str); } if (request.getParameter("tempPost") != null
		 * && !request.getParameter("tempPost").equals("")) { String
		 * str=request.getParameter("tempPost").trim(); tempPost =
		 * Integer.parseInt(str); }
		 * 
		 * if (request.getParameter("supernumPost") != null &&
		 * !request.getParameter("supernumPost").equals("")) { String
		 * str=request.getParameter("supernumPost").trim(); supernumPost =
		 * Integer.parseInt(str); }
		 */
		if (request.getParameter(SEARCH_NAME) != null && !request.getParameter(SEARCH_NAME).equals("")) {
			cadreName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", cadreId);
		generalMap.put("des", description);
		generalMap.put("name", cadreName);
		generalMap.put("strength", strength);
		// generalMap.put("permaPost", permaPost);
		// generalMap.put("tempPost", tempPost);
		// generalMap.put("supernumPost", supernumPost);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingCadreNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingCadreNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editCadreToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingCadreNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showCadreJsp";

		try {
			map = generalMasterHandlerService.showCadreJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "cadre";
		title = "update Cadre";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteCadre(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int cadreId = 0;
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
			cadreId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteCadre(cadreId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCadreJsp";

		try {
			map = generalMasterHandlerService.showCadreJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "cadre";
		title = "delete Cadre";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Special Official
	// ----------------------------------

	public ModelAndView searchSpecialOfficial(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String specialOfficialName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			specialOfficialName = request.getParameter(SEARCH_NAME);
		}
		map = generalMasterHandlerService
				.searchSpecialOfficial(specialOfficialName);
		jsp = "specialOfficial";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("specialOfficialName", specialOfficialName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showSpecialOfficialJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = generalMasterHandlerService.showSpecialOfficialJsp();
		String jsp = "specialOfficial";
		jsp += ".jsp";
		title = "SpecialOfficial";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSpecialOfficial(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasSpecialOfficial masSpecialOfficial = new MasSpecialOfficial();
		String specialOfficialName = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		log.info(specialOfficialName);
		if (request.getParameter(SEARCH_NAME) != null) {
			specialOfficialName = request.getParameter(SEARCH_NAME);
		}
		log.info(specialOfficialName);
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

		generalMap.put("name", specialOfficialName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List specialOfficialNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			specialOfficialNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((specialOfficialNameList.size() == 0 || specialOfficialNameList == null)
				&& (specialOfficialNameList.size() == 0 || specialOfficialNameList == null)) {
			masSpecialOfficial.setSpecialOfficialName(specialOfficialName);
			masSpecialOfficial.setStatus("y");

			Users users = new Users();
			users.setId(userId);
			masSpecialOfficial.setLastChgBy(users);

			masSpecialOfficial.setLastChgDate(currentDate);
			masSpecialOfficial.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addSpecialOfficial(masSpecialOfficial);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((specialOfficialNameList.size() != 0)
				|| specialOfficialNameList != null) {
			if ((specialOfficialNameList.size() != 0 || specialOfficialNameList != null)) {
				message = "Special Official Name already exists.";
			}
		}
		try {
			map = generalMasterHandlerService.showSpecialOfficialJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "specialOfficial";
		title = "Add Special Official";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editSpecialOfficial(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String specialOfficialName = "";
		int specialOfficialId = 0;
		Date changedDate = null;
		String changedTime = "";

		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			specialOfficialId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}

		if (request.getParameter(SEARCH_NAME) != null) {
			specialOfficialName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", specialOfficialId);
		generalMap.put("name", specialOfficialName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSpecialOfficialNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSpecialOfficialNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editSpecialOfficialToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingSpecialOfficialNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showSpecialOfficialJsp";

		try {
			map = generalMasterHandlerService.showSpecialOfficialJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "specialOfficial";
		title = "update SpecialOfficial";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteSpecialOfficial(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int specialOfficialId = 0;
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
			specialOfficialId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteSpecialOfficial(
				specialOfficialId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showSpecialOfficialJsp";

		try {
			map = generalMasterHandlerService.showSpecialOfficialJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "specialOfficial";
		title = "delete SpecialOfficial";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView generateReport(HttpServletRequest request,
	 * HttpServletResponse response) { HttpSession session =
	 * request.getSession(); Map<String, Object> mapResponse = new
	 * HashMap<String, Object>(); Map<String, Object> mapForDs = new
	 * HashMap<String, Object>(); List<MasHospital> masHospitaList = new
	 * ArrayList<MasHospital>(); int hospitalId = 0; String hospitalName = "";
	 * String qry=""; String searchField = "";
	 * 
	 * if (session.getAttribute("hospitalId") != null) { hospitalId = (Integer)
	 * session.getAttribute("hospitalId"); mapForDs.put("hospitalId",
	 * hospitalId); mapResponse =
	 * generalMasterHandlerService.getHospitalName(mapForDs); }
	 * 
	 * if (mapResponse.get("masHospitaList") != null) { masHospitaList = (List)
	 * mapResponse.get("masHospitaList"); hospitalName =
	 * masHospitaList.get(0).getHospitalName();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * String colCode=""; if (request.getParameter("colCode") != null &&
	 * !(request.getParameter("colCode").equals(""))) { colCode =
	 * request.getParameter("colCode"); } String colName=""; if
	 * (request.getParameter("colName") != null &&
	 * !(request.getParameter("colName").equals(""))) { colName =
	 * request.getParameter("colName"); } int searchRadio = 1; try { if
	 * (request.getParameter(SEARCH_FIELD) != null &&
	 * !(request.getParameter(SEARCH_FIELD).equals(""))) { searchField =
	 * request.getParameter(SEARCH_FIELD); }
	 * 
	 * if (request.getParameter(SELECTED_RADIO) != null &&
	 * !(request.getParameter(SELECTED_RADIO).equals(""))) { searchRadio =
	 * Integer.parseInt(request .getParameter(SELECTED_RADIO)); } } catch
	 * (Exception e) { e.printStackTrace(); }
	 * log.info("searchField---"+searchField); if (searchRadio == 1) {
	 * 
	 * if(!searchField.equals("")) {
	 * qry="where upper("+colCode+") like upper('%" +searchField +"%')"; } else
	 * { qry=""; } } else if (searchRadio == 2) { if(!searchField.equals("")) {
	 * qry="where upper("+colName+") like upper('%" +searchField +"%')"; } else
	 * { qry=""; } } else { qry=""; }
	 * 
	 * String jasper = null; if (request.getParameter(JASPER_FILE_NAME) != null)
	 * { jasper = request.getParameter(JASPER_FILE_NAME); } Map<String, Object>
	 * parameters = new HashMap<String, Object>(); parameters.put("qry", qry);
	 * parameters.put("hospitalName", hospitalName);
	 * parameters.put("SUBREPORT_DIR",
	 * getServletContext().getRealPath("/reports/"));
	 * 
	 * Map<String, Object> connectionMap =
	 * generalMasterHandlerService.getConnection();
	 * 
	 * HMSUtil.generateReport(jasper, parameters,(Connection)
	 * connectionMap.get("conn"), response, getServletContext());
	 * 
	 * return null; }
	 */

	public ModelAndView searchOrderNo(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String orderNo = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			orderNo = request.getParameter(CODE);
		}
		// log.info("======="+orderNo);
		map = generalMasterHandlerService.searchOrderNo(orderNo);
		jsp = "sanctionPostOrder";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("gradeCode", orderNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSanctionPostOrderJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = generalMasterHandlerService.showSanctionPostOrderJsp();
		String jsp = "sanctionPostOrder";
		jsp += ".jsp";
		title = "Unit";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSanctionPostOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasSanctionedPostOrder masSanctionedPostOrder = new HrMasSanctionedPostOrder();
		String payScaleCode = "";
		String gradeLevel = "";
		String desc = "";
		Date orderDateId = new Date();
		Date endDate = new Date();
		String orderNo = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId = 0;
		int cadre = 0;
		int noPost = 0;
		String type = "";
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter("payScaleCode") != null) {
			payScaleCode = request.getParameter("payScaleCode");
		}
		if (request.getParameter(CODE) != null) {
			orderNo = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			gradeLevel = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("remarks") != null
				&& !(request.getParameter("remarks").equals(""))) {

			desc = request.getParameter("remarks");
		}
		if (request.getParameter("cadre") != null
				&& !(request.getParameter("cadre").equals(""))) {

			cadre = Integer.parseInt("" + request.getParameter("cadre"));
		}

		if (request.getParameter("noPost") != null
				&& !(request.getParameter("noPost").equals(""))) {

			noPost = Integer.parseInt("" + request.getParameter("noPost"));
		}

		if (request.getParameter("type") != null
				&& !(request.getParameter("type").equals(""))) {

			type = request.getParameter("type");
		}
		if (request.getParameter("orderDateId") != null
				&& !(request.getParameter("orderDateId").equals(""))) {
			orderDateId = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("orderDateId"));

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

		generalMap.put("code", orderNo);
		generalMap.put("payScaleCode", payScaleCode);
		generalMap.put("name", gradeLevel);
		generalMap.put("orderDateId", orderDateId);
		generalMap.put("endDate", endDate);
		generalMap.put("remarks", desc);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List gradeCodeList = new ArrayList();
		List gradeLevelList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			gradeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		log.info("" + gradeCodeList.size());
		/*
		 * if (listMap.get("duplicateGeneralNameList") != null) { gradeLevelList
		 * = (List) listMap.get("duplicateGeneralNameList"); }
		 */
		boolean successfullyAdded = false;

		/*
		 * if ((gradeCodeList.size() == 0 || gradeCodeList == null) &&
		 * (gradeLevelList.size() == 0 || gradeLevelList == null)) {
		 */
		if ((gradeCodeList.size() == 0 || gradeCodeList == null)) {

			/*
			 * masGrade.setGradeCode(gradeCode);
			 * 
			 * masGrade.setPayScaleCode(payScaleCode);
			 * masGrade.setGradeLevel(gradeLevel);
			 * masGrade.setStartDate(startDate); masGrade.setEndDate(endDate);
			 * masGrade.setRemarks(remarks);
			 */
			masSanctionedPostOrder.setOrderNo(orderNo);
			masSanctionedPostOrder.setNoOfPosts(noPost);
			masSanctionedPostOrder.setOrderDate(orderDateId);
			masSanctionedPostOrder.setDescription(desc);
			masSanctionedPostOrder.setStatus("y");
			masSanctionedPostOrder.setType(type);

			MasCadre mc = new MasCadre();
			mc.setId(cadre);
			masSanctionedPostOrder.setCadre(mc);

			Users users = new Users();
			users.setId(userId);
			masSanctionedPostOrder.setLastChgBy(users);

			masSanctionedPostOrder.setLastChgDate(currentDate);
			masSanctionedPostOrder.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addSanctionedPostOrder(masSanctionedPostOrder);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		/*
		 * else if ((gradeCodeList.size() != 0 || gradeCodeList != null) ||
		 * (gradeLevelList.size() != 0) || gradeLevelList != null) { if
		 * ((gradeCodeList.size() != 0 || gradeCodeList != null) &&
		 * (gradeLevelList.size() == 0 || gradeLevelList == null)) {
		 */
		else if ((gradeCodeList.size() != 0 || gradeCodeList != null)) {

			if ((gradeCodeList.size() != 0 || gradeCodeList != null)) {

				message = "order No  already exists.";
			} /*
			 * else if ((gradeLevelList.size() != 0 || gradeLevelList != null)
			 * && (gradeCodeList.size() == 0 || gradeCodeList == null)) {
			 * 
			 * message = "Grade Level already exists."; } else if
			 * ((gradeCodeList.size() != 0 || gradeCodeList != null) &&
			 * (gradeLevelList.size() != 0 || gradeLevelList != null)) {
			 * 
			 * message = "Grade Code Code and Grade Level already exist."; }
			 */
		}

		try {
			map = generalMasterHandlerService.showSanctionPostOrderJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "sanctionPostOrder";
		title = "Add sanction Post Order";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editSanctionPostOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		MasGrade masGrade = new MasGrade();
		session = request.getSession();
		String payScaleCode = "";
		String gradeLevel = "";
		String remarks = "";
		Date startDate = new Date();
		int orderId = 0;
		String orderNo = "";
		Date changedDate = null;
		String changedTime = "";
		int noPost = 0;
		int cadre = 0;
		String type = "";
		Date orderDateId = new Date();
		String desc = "";
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			orderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("noPost") != null
				&& !(request.getParameter("noPost").equals(""))) {

			noPost = Integer.parseInt("" + request.getParameter("noPost"));
		}
		if (request.getParameter("cadre") != null
				&& !(request.getParameter("cadre").equals(""))) {

			cadre = Integer.parseInt("" + request.getParameter("cadre"));
		}

		if (request.getParameter("type") != null
				&& !(request.getParameter("type").equals(""))) {

			type = request.getParameter("type");
		}
		if (request.getParameter("orderDateId") != null
				&& !(request.getParameter("orderDateId").equals(""))) {
			orderDateId = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("orderDateId"));

		}
		if (request.getParameter(CODE) != null) {
			orderNo = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			gradeLevel = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("remarks") != null
				&& !(request.getParameter("remarks").equals(""))) {

			desc = request.getParameter("remarks");
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

		generalMap.put("id", orderId);

		generalMap.put("orderNo", orderNo);
		generalMap.put("remarks", desc);
		generalMap.put("name", gradeLevel);
		generalMap.put("userId", userId);
		generalMap.put("cadre", cadre);
		generalMap.put("type", type);
		generalMap.put("noPost", noPost);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("orderDateId", orderDateId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingGradeLevelList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingGradeLevelList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editSanctionPostOrderToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} /*
		 * else if (existingGradeLevelList.size() > 0) { message =
		 * "Grade Level already exists."; }
		 */

		url = "/hms/hms/generalMaster?method=showSanctionPostOrderJsp";

		try {
			map = generalMasterHandlerService.showSanctionPostOrderJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "sanctionPostOrder";
		title = "sanction Post Order";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteSanctionPostOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int orderId = 0;
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
			orderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteSanctionPostOrder(
				orderId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showSanctionPostOrderJsp";

		try {
			map = generalMasterHandlerService.showSanctionPostOrderJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "sanctionPostOrder";
		title = "sanction Post Order";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSanctionPostInstituteJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = generalMasterHandlerService.showSanctionPostInstitute();
		String jsp = "sanctionPostInstitute";
		jsp += ".jsp";
		title = "Unit";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addSanctionInstitutePost(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HrInstitutionalSanctionedPost hrInstitutionalSanctionedPost = new HrInstitutionalSanctionedPost();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String gradeLevel = "";
		Date currentDate = new Date();
		Date fromDate = new Date();
		Date toDate = new Date();
		int permaPost = 0;
		int tempPost = 0;
		int supernumPost = 0;
		int userId = 0;
		int cadre = 0;
		int designation = 0;
		int sploffName = 0;
		int institute = 0;
		int dept = 0;
		int sanctionPostNo = 0;
		String refOrder = "";
		String type = "";
		HttpSession session = request.getSession();
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter(CODE) != null) {
			refOrder = request.getParameter(CODE);
		}
		if (request.getParameter("cadre") != null
				&& !(request.getParameter("cadre").equals(""))) {
			cadre = Integer.parseInt("" + request.getParameter("cadre"));
		}
		if (request.getParameter("designation") != null&& !(request.getParameter("designation").equals(""))) {
			designation = Integer.parseInt(""
					+ request.getParameter("designation"));
		}
		if (request.getParameter("permaPost") != null) {
			permaPost = Integer.parseInt(request.getParameter("permaPost").trim());
		}
		if (request.getParameter("tempPost") != null) {
			tempPost = Integer.parseInt(request.getParameter("tempPost").trim());
		}
		if (request.getParameter("supernumPost") != null) {
			supernumPost = Integer.parseInt(request
					.getParameter("supernumPost").trim());
		}
		if (request.getParameter("sploffName") != null
				&& !(request.getParameter("sploffName").equals(""))) {

			sploffName = Integer.parseInt(""
					+ request.getParameter("sploffName"));
		}
		if (request.getParameter("institute") != null
				&& !(request.getParameter("institute").equals(""))) {

			institute = Integer
					.parseInt("" + request.getParameter("institute"));
		}
		if (request.getParameter("dept") != null
				&& !(request.getParameter("dept").equals(""))) {

			dept = Integer.parseInt("" + request.getParameter("dept"));
		}
		if (request.getParameter("sanctionPostNo") != null
				&& !(request.getParameter("sanctionPostNo").equals(""))) {

			sanctionPostNo = Integer.parseInt(""
					+ request.getParameter("sanctionPostNo"));
		}
		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));
		}
		if (request.getParameter(END_DATE) != null
				&& !(request.getParameter(END_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE));
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
		if (request.getParameter(RequestConstants.POJO_NAME) != null) {
			pojoName = request.getParameter(RequestConstants.POJO_NAME);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", refOrder);
		generalMap.put("cadre", cadre);
		generalMap.put("designation", designation);
		generalMap.put("permaPost", permaPost);
		generalMap.put("tempPost", tempPost);
		generalMap.put("supernumPost", supernumPost);
		generalMap.put("sploffName", sploffName);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		generalMap.put("institute", institute);
		generalMap.put("dept", dept);
		generalMap.put("sanctionPostNo", sanctionPostNo);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("name", pojoName);
		generalMap.put("status", request.getParameter(STATUS));
		 
		/* listMap = commonMasterHandlerService
		  .checkForExistingMasters(generalMap);
		  
		 List gradeCodeList = new ArrayList(); List gradeLevelList = new ArrayList();
		 
		  if (listMap.get("duplicateGeneralCodeList") != null) { gradeCodeList
		 = (List) listMap.get("duplicateGeneralCodeList"); }
		 log.info("" + gradeCodeList.size()); if
		 (listMap.get("duplicateGeneralNameList") != null) { gradeLevelList =
		 (List) listMap.get("duplicateGeneralNameList"); }
		  */
		boolean successfullyAdded = false;
		 /* if ((gradeCodeList.size() == 0 || gradeCodeList == null) &&
		 (gradeLevelList.size() == 0 || gradeLevelList == null)) {
		  if ((gradeCodeList.size() == 0 || gradeCodeList == null)) { 
*/
		hrInstitutionalSanctionedPost.setRefOrderId(refOrder);
		hrInstitutionalSanctionedPost.setFromDate(fromDate);
		hrInstitutionalSanctionedPost.setToDate(toDate);
		hrInstitutionalSanctionedPost.setStatus("y");
		hrInstitutionalSanctionedPost.setPostNo(sanctionPostNo);
		hrInstitutionalSanctionedPost.setPermanentPost(permaPost);
		hrInstitutionalSanctionedPost.setTemporaryPost(tempPost);
		hrInstitutionalSanctionedPost.setSupernumeraryPost(supernumPost);
		MasHospital mh = new MasHospital();
		mh.setId(institute);
		hrInstitutionalSanctionedPost.setInstitution(mh);

		MasEmployeeDepartment md = new MasEmployeeDepartment();
		md.setId(dept); 
		hrInstitutionalSanctionedPost.setDepartment(md); 

		MasCadre mc = new MasCadre();
		mc.setId(cadre);
		hrInstitutionalSanctionedPost.setCadre(mc);

		MasRank mr = new MasRank();
		mr.setId(designation);
		hrInstitutionalSanctionedPost.setRank(mr);

		Users users = new Users();
		users.setId(userId);
		hrInstitutionalSanctionedPost.setLastChgBy(users);
		if (sploffName != 0) {
			MasSpecialOfficial ms = new MasSpecialOfficial();
			ms.setId(sploffName);
			hrInstitutionalSanctionedPost.setSpecialOfficial(ms);
		}
		hrInstitutionalSanctionedPost.setLastChgDate(currentDate);
		hrInstitutionalSanctionedPost.setLastChgTime(currentTime);
		successfullyAdded = generalMasterHandlerService
				.addSanctionInstitutePost(hrInstitutionalSanctionedPost);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		 /*}
         else if ((gradeCodeList.size() != 0 || gradeCodeList != null) ||
		  (gradeLevelList.size() != 0) || gradeLevelList != null) { if
		  ((gradeCodeList.size() != 0 || gradeCodeList != null) &&
		   (gradeLevelList.size() == 0 || gradeLevelList == null)) {
		  
		  } else if ((gradeCodeList.size() != 0 || gradeCodeList != null)) {
		 
		  if ((gradeCodeList.size() != 0 || gradeCodeList != null)) {
		 
		 message = "order No  already exists."; } else if
		  ((gradeLevelList.size() != 0 || gradeLevelList != null) &&
		 (gradeCodeList.size() == 0 || gradeCodeList == null)) {
		  
		 message = "Grade Level already exists."; } else if
		  ((gradeCodeList.size() != 0 || gradeCodeList != null) &&
		  (gradeLevelList.size() != 0 || gradeLevelList != null)) {
		 
	    message = "Grade Code Code and Grade Level already exist."; } }
         }
		  }*/
		 
		try {
			map = generalMasterHandlerService.showSanctionPostInstitute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "sanctionPostInstitute";
		title = "Add sanction Post Order";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
          

	public ModelAndView searchSanctionInstitutePost(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String refOrder = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			refOrder = request.getParameter(CODE);
		}
		// log.info("======="+orderNo);
		map = generalMasterHandlerService.searchSanctionInstitutePost(refOrder);
		jsp = "sanctionPostInstitute";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("refOrder", refOrder);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editSanctionInstitutePost(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		MasGrade masGrade = new MasGrade();
		session = request.getSession();
		String payScaleCode = "";
		String gradeLevel = "";
		String remarks = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		int orderId = 0;
		String refOrderNo = "";
		Date changedDate = null;
		String changedTime = "";
		int sploffName = 0;
		int cadre = 0;
		int institute = 0;
		int dept = 0;
		int sanctionPostNo = 0;

		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			orderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("cadre") != null
				&& !(request.getParameter("cadre").equals(""))) {

			cadre = Integer.parseInt("" + request.getParameter("cadre"));
		}

		if (request.getParameter("sploffName") != null
				&& !(request.getParameter("sploffName").equals(""))) {

			sploffName = Integer.parseInt(""
					+ request.getParameter("sploffName"));
		}

		if (request.getParameter("institute") != null
				&& !(request.getParameter("institute").equals(""))) {

			institute = Integer
					.parseInt("" + request.getParameter("institute"));
		}
		if (request.getParameter("dept") != null
				&& !(request.getParameter("dept").equals(""))) {

			dept = Integer.parseInt("" + request.getParameter("dept"));
		}

		if (request.getParameter("sanctionPostNo") != null
				&& !(request.getParameter("sanctionPostNo").equals(""))) {

			sanctionPostNo = Integer.parseInt(""
					+ request.getParameter("sanctionPostNo"));
		}

		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));

		}
		if (request.getParameter(END_DATE) != null
				&& !(request.getParameter(END_DATE).equals(""))) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE));

		}
		if (request.getParameter(CODE) != null) {
			refOrderNo = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			gradeLevel = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", orderId);
		generalMap.put("refOrderNo", refOrderNo);
		generalMap.put("name", gradeLevel);
		generalMap.put("userId", userId);
		generalMap.put("cadre", cadre);
		generalMap.put("dept", dept);
		generalMap.put("sanctionPostNo", sanctionPostNo);
		generalMap.put("sploffName", sploffName);
		generalMap.put("institute", institute);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("toDate", toDate);
		generalMap.put("fromDate", fromDate);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingGradeLevelList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingGradeLevelList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editSanctionInstitutePostToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} /*
		 * else if (existingGradeLevelList.size() > 0) { message =
		 * "Grade Level already exists."; }
		 */

		url = "/hms/hms/generalMaster?method=showSanctionPostInstituteJsp";

		try {
			map = generalMasterHandlerService.showSanctionPostInstitute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "sanctionPostInstitute";
		title = "sanction Post Order";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteSanctionInstitutePost(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int refOrderId = 0;
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
			refOrderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		int userId = 0;
		HttpSession session = request.getSession();
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteSanctionInstitutePost(
				refOrderId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showSanctionPostInstituteJsp";

		try {
			map = generalMasterHandlerService.showSanctionPostInstitute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "sanctionPostInstitute";
		title = "sanction Post Order";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public GeneralMasterHandlerService getGeneralMasterHandlerService() {
		return generalMasterHandlerService;
	}

	public void setGeneralMasterHandlerService(
			GeneralMasterHandlerService generalMasterHandlerService) {
		this.generalMasterHandlerService = generalMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	// --------------------- GROUP MASTER
	// ------------------------------------------

	/*
	 * public ModelAndView editGroupParaMaster(HttpServletRequest request,
	 * HttpServletResponse response) { log.info();
	 * 
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>(); Map<String,
	 * Object> generalMap = new HashMap<String, Object>(); session =
	 * request.getSession(); String parameterCode = ""; String parameterName =
	 * ""; String valueType = "";
	 * 
	 * String changedBy = "";
	 * 
	 * @SuppressWarnings("unused") Date changedDate = null;
	 * 
	 * @SuppressWarnings("unused") String changedTime = ""; Date currentDate =
	 * null;
	 * 
	 * if (request.getParameter(COMMON_ID) != null &&
	 * !(request.getParameter(COMMON_ID).equals(""))) { id =
	 * Integer.parseInt(request.getParameter(COMMON_ID)); }
	 * 
	 * if (request.getParameter(CODE) != null &&
	 * !(request.getParameter(CODE).equals(""))) { parameterCode =
	 * request.getParameter(CODE); log.info("==============="); }
	 * 
	 * if (request.getParameter(SEARCH_NAME) != null &&
	 * !(request.getParameter(SEARCH_NAME).equals(""))) { parameterName =
	 * request.getParameter(SEARCH_NAME);
	 * 
	 * log.info("parameterName 45455"+request.getParameter(SEARCH_NAME)
	 * ); }
	 * 
	 * log.info("parameterName 45455"+request.getParameter(SEARCH_NAME)
	 * );
	 * 
	 * if (request.getParameter(VALUE_TYPE) != null) { valueType=
	 * request.getParameter(VALUE_TYPE);
	 * log.info("VALUE_TYPE"+request.getParameter(VALUE_TYPE)); } if
	 * (request.getParameter(IMG_REQ) != null) { imageReq =
	 * request.getParameter(IMG_REQ);
	 * log.info("IMG_REQ"+request.getParameter(IMG_REQ)); } if
	 * (request.getParameter(COMMON) != null) { common =
	 * request.getParameter(COMMON);
	 * log.info("COMMON"+request.getParameter(COMMON)); }
	 * 
	 * 
	 * if (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) { changedBy =
	 * request.getParameter(CHANGED_BY); } if
	 * (request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))) { changedTime =
	 * request.getParameter(CHANGED_TIME); } if
	 * (request.getParameter("pojoName") != null) { pojoName =
	 * request.getParameter("pojoName"); } if
	 * (request.getParameter("pojoPropertyName") != null) { pojoPropertyName =
	 * request.getParameter("pojoPropertyName"); } if
	 * (request.getParameter("title") != null) { title =
	 * request.getParameter("title"); } changedDate = new Date(); changedTime =
	 * (String) HMSUtil.getCurrentDateAndTime().get( "currentTime");
	 * 
	 * generalMap.put("id", id); generalMap.put("parameterCode", parameterCode);
	 * generalMap.put("parameterName", parameterName);
	 * generalMap.put("valueType", valueType);
	 * 
	 * 
	 * generalMap.put("changedBy", changedBy);
	 * 
	 * generalMap.put("currentDate", changedDate); generalMap.put("currentTime",
	 * changedTime);
	 * 
	 * Map<String, Object> listMap = new HashMap<String, Object>();
	 * generalMap.put("pojoPropertyName", pojoPropertyName);
	 * generalMap.put("pojoName", pojoName); generalMap.put("flag", true);
	 * listMap = commonMasterHandlerService
	 * .checkForExistingMasters(generalMap); List existingBloodGroupNameList =
	 * (List) listMap .get("duplicateMastersList"); boolean dataUpdated = false;
	 * 
	 * 
	 * if (existingBloodGroupNameList.size() == 0) { dataUpdated =
	 * generalMasterHandlerService.editParameterToDatabase(generalMap);
	 * 
	 * 
	 * if (dataUpdated == true) { message = "Data updated Successfully !!"; }
	 * else { message = "Data Cant Be Updated !!"; } } else if
	 * (existingBloodGroupNameList.size() > 0) { message =
	 * "Name already exists."; } url =
	 * "/hms/hms/generalMaster?method=showParameter"; try { map =
	 * generalMasterHandlerService.showParameterJsp(); } catch (Exception e) {
	 * e.printStackTrace(); } jsp = PARAMETER_MASTER; title =
	 * "Update Parameter"; jsp += ".jsp"; map.put("contentJsp", jsp);
	 * map.put("title", title); map.put("message", message); return new
	 * ModelAndView("index", "map", map); }
	 */

	// ---------------------------- ------------------------------------------

	public ModelAndView showDepartWiseGrpMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();

		if (request.getParameter("searchField") != null
				&& request.getParameter("searchField") != "") {
			details.put("depName", request.getParameter("searchField"));

		}

		map = generalMasterHandlerService.showDepartWiseGrpMaster(details);

		List<SpDeptGroupT> deptGroupTs = (List<SpDeptGroupT>) map
				.get("deptGroupTs");
		
		log.info("deptGroupTs" + deptGroupTs.size());

		Map<Integer, List<SpDeptGroupT>> mapForSpDepGroupPaT = new HashMap<Integer, List<SpDeptGroupT>>();

		for (SpDeptGroupT spDpgroupT : deptGroupTs) {
			if (mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId()) != null) {

				List<SpDeptGroupT> subGroupT1 = mapForSpDepGroupPaT
						.get(spDpgroupT.getDeptGroupM().getId());
				subGroupT1.add(spDpgroupT);
				mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(),
						subGroupT1);

			} else {

				List<SpDeptGroupT> subGroupT = new ArrayList<SpDeptGroupT>();
				subGroupT.add(spDpgroupT);
				mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(),
						subGroupT);
			}

		}

		int i = 0;

		for (SpDeptGroupT spDepartGroupT : deptGroupTs) {
			if (i != spDepartGroupT.getDeptGroupM().getId()) {
				
				i = spDepartGroupT.getDeptGroupM().getId();

			}

		}

		String jsp = DEPARTMENT_GROUP;
		jsp += ".jsp";
		title = "SpDepartParameter";
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		map.put("title", title);
		map.put("mapForSpDepGroupPaT", mapForSpDepGroupPaT);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addDepartmentGrPara(HttpServletRequest request,
			HttpServletResponse response) {

		log.info("Method  addDepartmentGrPara()");

		Map<String, Object> map = new HashMap<String, Object>();
		SpDeptGroupM deptGroupM = new SpDeptGroupM();
		MasSpecialityGroup masGroup = new MasSpecialityGroup();
		MasDepartment masDepartment = new MasDepartment();

		HttpSession session = request.getSession();

		String grpName = " ";
		String paraMeterVales[] = null;
		String dpartName = " ";

		int id = 0;
		String changedBy = "";

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Users userId = (Users) session.getAttribute("users");

		paraMeterVales = request.getParameterValues("paraMeterVales");

		log.info("paraMeterVales" + paraMeterVales.length);
		log.info("grpName   " + request.getParameter("grpName"));

		try {

			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
				log.info("SEARCH_NAME"
						+ request.getParameter(SEARCH_NAME));
			}

			if (request.getParameter("dpartName") != null) {
				dpartName = request.getParameter("dpartName");
				log.info("Department Name"
						+ request.getParameter("dpartName"));
			}

			if (request.getParameter("grpName") != null) {
				grpName = request.getParameter("grpName");
				log.info("Group Name" + request.getParameter("grpName"));
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

		List groupCodeList = new ArrayList();
		List groupNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			groupCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			groupNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((groupCodeList.size() == 0 || groupCodeList == null)
				&& (groupNameList.size() == 0 || groupNameList == null)) {

			masGroup.setId(Integer.parseInt("" + grpName));
			masDepartment.setId(Integer.parseInt("" + dpartName));

			deptGroupM.setSpGroup(masGroup);
			deptGroupM.setDepartment(masDepartment);
			deptGroupM.setLastChgBy(userId);
			deptGroupM.setLastChgDate(currentDate);
			deptGroupM.setLastChgTime(currentTime);
			deptGroupM.setStatus("Y");

			Map m = new HashMap();

			m.put("deptGroupM", deptGroupM);
			m.put("paraMeterVales", paraMeterVales);

			successfullyAdded = generalMasterHandlerService
					.addDepartmentGrPara(m);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((groupCodeList.size() != 0 || groupCodeList != null)
				|| (groupNameList.size() != 0) || groupNameList != null) {
			if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() == 0 || groupNameList == null)) {
				message = "Group Code already exists.";
			} else if ((groupNameList.size() != 0 || groupNameList != null)
					&& (groupCodeList.size() == 0 || groupCodeList == null)) {
				message = "Group Name already exists.";
			} else if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() != 0 || groupNameList != null)) {
				message = "Group Code and State exist.";
			}

		}
		Map<String, Object> details = new HashMap<String, Object>();

		try {
			map = generalMasterHandlerService.showDepartWiseGrpMaster(details);

		} catch (Exception e) {
			e.printStackTrace();
		}

		List<SpDeptGroupT> deptGroupTs = (List<SpDeptGroupT>) map
				.get("deptGroupTs");
		
		log.info("deptGroupTs" + deptGroupTs.size());

		Map<Integer, List<SpDeptGroupT>> mapForSpDepGroupPaT = new HashMap<Integer, List<SpDeptGroupT>>();

		for (SpDeptGroupT spDpgroupT : deptGroupTs) {
			if (mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId()) != null) {

				List<SpDeptGroupT> subGroupT1 = mapForSpDepGroupPaT
						.get(spDpgroupT.getDeptGroupM().getId());
				subGroupT1.add(spDpgroupT);
				mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(),
						subGroupT1);

			} else {

				List<SpDeptGroupT> subGroupT = new ArrayList<SpDeptGroupT>();
				subGroupT.add(spDpgroupT);
				mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(),
						subGroupT);
			}
		}
		jsp = DEPARTMENT_GROUP;
		title = "SpDepartParameter";
		jsp += ".jsp";
		// map.put("pageNo",
		// Integer.parseInt(request.getParameter("pageNoEdit")));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		map.put("mapForSpDepGroupPaT", mapForSpDepGroupPaT);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteDepartWiseGrpMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int id = 0;
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
			id = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteDepartWiseGrpMaster(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showDepartWiseGrpMaster";

		Map<String, Object> details = new HashMap<String, Object>();

		try {
			map = generalMasterHandlerService.showDepartWiseGrpMaster(details);

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<SpDeptGroupT> deptGroupTs = (List<SpDeptGroupT>) map
				.get("deptGroupTs");
		
		log.info("deptGroupTs" + deptGroupTs.size());

		Map<Integer, List<SpDeptGroupT>> mapForSpDepGroupPaT = new HashMap<Integer, List<SpDeptGroupT>>();

		for (SpDeptGroupT spDpgroupT : deptGroupTs) {
			if (mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId()) != null) {

				List<SpDeptGroupT> subGroupT1 = mapForSpDepGroupPaT
						.get(spDpgroupT.getDeptGroupM().getId());
				subGroupT1.add(spDpgroupT);
				mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(),
						subGroupT1);

			} else {

				List<SpDeptGroupT> subGroupT = new ArrayList<SpDeptGroupT>();
				subGroupT.add(spDpgroupT);
				mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(),
						subGroupT);
			}
		}

		jsp = DEPARTMENT_GROUP;
		title = "Group Parameter";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		map.put("mapForSpDepGroupPaT", mapForSpDepGroupPaT);
		return new ModelAndView("index", "map", map);

	}

	// ----------------------- ---------------------------------------

	// -------------------------------- Ward
	// ------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showWardJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showWard();
		String jsp = "ward";
		jsp += ".jsp";
		title = "ward";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addWard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasWard masWard = new MasWard();
		int postcodeId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");

		int villageId = 0,lsgId=0,districtId=0;

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

//			if (request.getParameter("villageId") != null
//					&& !(request.getParameter("villageId").equals("0"))) {
//				villageId = Integer.parseInt(request.getParameter("villageId"));
//			}

			//govind code
			
			if (request.getParameter("lsgId") != null
					&& !(request.getParameter("lsgId").equals("0"))) {
				lsgId = Integer.parseInt(request.getParameter("lsgId"));
				
			}
			
			if (request.getParameter("districtId") != null//govind code 11-7-2016
					&& !(request.getParameter("districtId").equals("0"))) {
				districtId = Integer.parseInt(request.getParameter("districtId"));
				
			}
			//end
			
			
			if (request.getParameter(POST_CODE_ID) != null
					&& !(request.getParameter(POST_CODE_ID).equals("0"))) {
				postcodeId = Integer.parseInt(request
						.getParameter(POST_CODE_ID));
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
		List wardCodeList = new ArrayList();
		List wardNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			wardCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			wardNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((wardCodeList.size() == 0 || wardCodeList == null)
				&& (wardNameList.size() == 0 || wardNameList == null)) {
			masWard.setWardCode(code);
			masWard.setWardName(name);

			masWard.setStatus("Y");

			Users users = new Users();
			users.setId(userId);
			masWard.setLastChgBy(users);

			/*
			 * MasHospital subCenter = new MasHospital();
			 * subCenter.setId(hospitalId); masWard.setSubCenter(subCenter);
			 */

//			MasVillage masVillage = new MasVillage();
//			masVillage.setId(villageId);
//			masWard.setVillage(masVillage);

			//govind code
			MasLsg masLsg = new MasLsg();
			masLsg.setId(lsgId);
			masWard.setLsg(masLsg);
			
			MasDistrict masDistrict=new MasDistrict();
			masDistrict.setId(districtId);
			masWard.setDistrict(masDistrict);
			
			//end
			
			masWard.setLastChgDate(currentDate);
			masWard.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService.addWard(masWard);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((wardCodeList.size() != 0 || wardCodeList != null)
				|| (wardNameList.size() != 0) || wardNameList != null) {
			if ((wardCodeList.size() != 0 || wardCodeList != null)
					&& (wardNameList.size() == 0 || wardNameList == null)) {
				message = "Ward Code already exists.";
			} else if ((wardNameList.size() != 0 || wardNameList != null)
					&& (wardCodeList.size() == 0 || wardCodeList == null)) {
				message = "Ward Name already exists.";
			} else if ((wardCodeList.size() != 0 || wardCodeList != null)
					&& (wardCodeList.size() != 0 || wardNameList != null)) {
				message = "Ward Code and Name exist.";
			}
		}
		try {
			map = generalMasterHandlerService.showWard();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// jsp="ward"_JSP;
		// title="Add Ward";
		// jsp += ".jsp";

		String jsp = "ward";
		title = " Add ward";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editWard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String wardCode = "";
		String wardName = "";
		int villageId = 0,lsgId=0,districtId=0;
		int wardId = 0;
		Date changedDate = null;
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
				wardId = Integer.parseInt(request.getParameter(COMMON_ID));
			}

//			if (request.getParameter("villageId") != null
//					&& !(request.getParameter("villageId").equals("0"))) {
//				villageId = Integer.parseInt(request.getParameter("villageId"));
//			}
			
			//govind code
			
			if (request.getParameter("lsgId") != null
					&& !(request.getParameter("lsgId").equals("0"))) {
				lsgId = Integer.parseInt(request.getParameter("lsgId"));
				
			}
			
			if (request.getParameter("districtId") != null
					&& !(request.getParameter("districtId").equals("0"))) {
				districtId = Integer.parseInt(request.getParameter("districtId"));
				
			}
			//end
			
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				wardCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				wardName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", wardId);
			generalMap.put("wardCode", wardCode);
			generalMap.put("name", wardName);
			generalMap.put("hospitalId", hospitalId);
			//generalMap.put("villageId", villageId);
			//govind code
			generalMap.put("lsgId", lsgId);
			generalMap.put("districtId", districtId);
			//end code
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			Map<String, Object> listMap = new HashMap<String, Object>();

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingWardNameList = (List) listMap
					.get("duplicateMastersList");
			boolean dataUpdated = false;

			if (existingWardNameList.size() == 0) {
				dataUpdated = generalMasterHandlerService.editWard(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingWardNameList.size() > 0) {
				message = "Name already exists.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			map = generalMasterHandlerService.showWard();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// jsp="ward"_JSP;
		// title="Edit Ward";
		// jsp += ".jsp";

		String jsp = "ward";
		title = " Edit ward";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchWard(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String wardCode = null;
		String wardName = null;
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
			wardCode = searchField;
			wardName = null;

		} else {
			wardCode = null;
			wardName = searchField;
		}

		//

		map = generalMasterHandlerService.searchWard(wardCode, wardName);

		jsp = "ward";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("wardCode", wardCode);
		map.put("wardName", wardName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteWard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int wardId = 0;
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
			wardId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService
				.deleteWard(wardId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showWardJsp";
		try {
			map = generalMasterHandlerService.showWard();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "ward";
		title = "delete Ward";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------------
	// ElectricalSection----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showElectricalSectionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showElectricalSection();
		String jsp = "electricalSection";
		jsp += ".jsp";
		title = "ElectricalSection";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addElectricalSection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		PhMasElectricalSection phMasElectricalSection = new PhMasElectricalSection();
		int villageId = 0;
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

			if (!request.getParameter(STATE_ID).equals("0")) {
				villageId = Integer.parseInt(request.getParameter(STATE_ID));
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

		List electricalSectionCodeList = new ArrayList();
		List electricalSectionNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			electricalSectionCodeList = (List) listMap
					.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			electricalSectionNameList = (List) listMap
					.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((electricalSectionCodeList.size() == 0 || electricalSectionCodeList == null)
				&& (electricalSectionNameList.size() == 0 || electricalSectionNameList == null)) {
			phMasElectricalSection.setElectricalSectionCode(code);
			phMasElectricalSection.setElectricalSectionName(name);
			if (villageId != 0) {
				MasVillage masVillage = new MasVillage();
				masVillage.setId(villageId);
				phMasElectricalSection.setVillage(masVillage);
			}
			phMasElectricalSection.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			phMasElectricalSection.setLastChgBy(users);
			phMasElectricalSection.setLastChgDate(currentDate);
			phMasElectricalSection.setLastChgTime(currentTime);
			Map<String, Object> electricalSectionMap = new HashMap<String, Object>();

			log.info("phMasElectricalSection "
					+ phMasElectricalSection);

			electricalSectionMap.put("phMasElectricalSection",
					phMasElectricalSection);
			electricalSectionMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addElectricalSection(electricalSectionMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((electricalSectionCodeList.size() != 0 || electricalSectionCodeList != null)
				|| (electricalSectionNameList.size() != 0)
				|| electricalSectionNameList != null) {
			if ((electricalSectionCodeList.size() != 0 || electricalSectionCodeList != null)
					&& (electricalSectionNameList.size() == 0 || electricalSectionNameList == null)) {
				message = "ElectricalSection Code already exists.";
			} else if ((electricalSectionNameList.size() != 0 || electricalSectionNameList != null)
					&& (electricalSectionCodeList.size() == 0 || electricalSectionCodeList == null)) {
				message = "ElectricalSection Name already exists.";
			} else if ((electricalSectionCodeList.size() != 0 || electricalSectionCodeList != null)
					&& (electricalSectionNameList.size() != 0 || electricalSectionNameList != null)) {
				message = "ElectricalSection Code and ElectricalSection exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showElectricalSection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "electricalSection";
		title = "Add ElectricalSection";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editElectricalSection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String electricalSectionCode = "";
		String name = "";
		int villageId = 0;
		int electricalSectionId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(STATE_ID) != null
					&& !(request.getParameter(STATE_ID).equals(""))) {
				villageId = Integer.parseInt(request.getParameter(STATE_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				electricalSectionId = Integer.parseInt(request
						.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				electricalSectionCode = request.getParameter(CODE);
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

			generalMap.put("id", electricalSectionId);
			generalMap.put("electricalSectionCode", electricalSectionCode);
			generalMap.put("name", name);
			generalMap.put("villageId", villageId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService
					.editElectricalSection(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showElectricalSection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "electricalSection";
		title = "Edit ElectricalSection";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchElectricalSection(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String electricalSectionCode = null;
		String electricalSectionName = null;
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
			electricalSectionCode = searchField;
			electricalSectionName = null;

		} else {
			electricalSectionCode = null;
			electricalSectionName = searchField;
		}
		map = generalMasterHandlerService.searchElectricalSection(
				electricalSectionCode, electricalSectionName);

		jsp = "electricalSection";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("electricalSectionCode", electricalSectionCode);
		map.put("electricalSectionName", electricalSectionName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteElectricalSection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int electricalSectionId = 0;
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
			electricalSectionId = Integer.parseInt(request
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
		dataDeleted = generalMasterHandlerService.deleteElectricalSection(
				electricalSectionId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showElectricalSectionJsp";

		try {
			map = generalMasterHandlerService.showElectricalSection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "electricalSection";
		title = "delete ElectricalSection";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ---------------------------------------
	// Panchayat----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showPanchayatJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showPanchayat();
		String jsp = "panchayat";
		jsp += ".jsp";
		title = "Panchayat";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPanchayat(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		PhMasPanchayat phMasPanchayat = new PhMasPanchayat();
		int assemblyId = 0;
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

			if (!request.getParameter(STATE_ID).equals("0")) {
				assemblyId = Integer.parseInt(request.getParameter(STATE_ID));
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

		List panchayatCodeList = new ArrayList();
		List panchayatNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			panchayatCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			panchayatNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((panchayatCodeList.size() == 0 || panchayatCodeList == null)
				&& (panchayatNameList.size() == 0 || panchayatNameList == null)) {
			phMasPanchayat.setPanchayatCode(code);
			phMasPanchayat.setPanchayatName(name);
			if (assemblyId != 0) {
				PhMasParliyamentAssembly phMasParliyamentAssembly = new PhMasParliyamentAssembly();
				phMasParliyamentAssembly.setId(assemblyId);
				phMasPanchayat.setAssembly(phMasParliyamentAssembly);
			}
			phMasPanchayat.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			phMasPanchayat.setLastChgBy(users);
			phMasPanchayat.setLastChgDate(currentDate);
			phMasPanchayat.setLastChgTime(currentTime);
			Map<String, Object> panchayatMap = new HashMap<String, Object>();

			log.info("phMasPanchayat " + phMasPanchayat);

			panchayatMap.put("phMasPanchayat", phMasPanchayat);
			panchayatMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addPanchayat(panchayatMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((panchayatCodeList.size() != 0 || panchayatCodeList != null)
				|| (panchayatNameList.size() != 0) || panchayatNameList != null) {
			if ((panchayatCodeList.size() != 0 || panchayatCodeList != null)
					&& (panchayatNameList.size() == 0 || panchayatNameList == null)) {
				message = "Panchayat Code already exists.";
			} else if ((panchayatNameList.size() != 0 || panchayatNameList != null)
					&& (panchayatCodeList.size() == 0 || panchayatCodeList == null)) {
				message = "Panchayat Name already exists.";
			} else if ((panchayatCodeList.size() != 0 || panchayatCodeList != null)
					&& (panchayatNameList.size() != 0 || panchayatNameList != null)) {
				message = "Panchayat Code and Panchayat exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showPanchayat();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "panchayat";
		title = "Add Panchayat";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editPanchayat(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String panchayatCode = "";
		String name = "";
		int assemblyId = 0;
		int panchayatId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(STATE_ID) != null
					&& !(request.getParameter(STATE_ID).equals(""))) {
				assemblyId = Integer.parseInt(request.getParameter(STATE_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				panchayatId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				panchayatCode = request.getParameter(CODE);
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

			generalMap.put("id", panchayatId);
			generalMap.put("panchayatCode", panchayatCode);
			generalMap.put("name", name);
			generalMap.put("assemblyId", assemblyId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService.editPanchayat(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showPanchayat();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "panchayat";
		title = "Edit Panchayat";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPanchayat(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String panchayatCode = null;
		String panchayatName = null;
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
			panchayatCode = searchField;
			panchayatName = null;

		} else {
			panchayatCode = null;
			panchayatName = searchField;
		}
		map = generalMasterHandlerService.searchPanchayat(panchayatCode,
				panchayatName);

		jsp = "panchayat";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("panchayatCode", panchayatCode);
		map.put("panchayatName", panchayatName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletePanchayat(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int panchayatId = 0;
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
			panchayatId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deletePanchayat(panchayatId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showPanchayatJsp";

		try {
			map = generalMasterHandlerService.showPanchayat();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "panchayat";
		title = "delete Panchayat";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * Methods By Mansi
	 */
	public ModelAndView showLocalityJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = generalMasterHandlerService.showLocalityJsp();
		String jsp = "locality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addLocality(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);

		map = generalMasterHandlerService.addLocality(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "locality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateLocality(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		map = generalMasterHandlerService.updateLocality(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "locality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteLocality(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteLocality(box);
		if (dataDeleted == true) {
			if (box.getString("flag").equals("InActivate"))
				message = "Record is InActivated successfully !!";
			else if (box.getString("flag").equals("Activate"))
				message = "Record is Activated successfully !!";
		} else {
			message = "Some Problem occured!";
		}
		try {
			map = generalMasterHandlerService.showLocalityJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "locality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDepotUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = generalMasterHandlerService.searchLocality(box);
		jsp = "locality";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------------
	// Parliyament----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showParliyamentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showParliyament();
		String jsp = "parliyament";
		jsp += ".jsp";
		title = "Parliyament";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addParliyament(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		PhMasParliyamentAssembly phMasParliyamentAssembly = new PhMasParliyamentAssembly();
		int districtId = 0;
		String changedBy = " ";

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		HttpSession session = request.getSession();
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

			if (request.getParameter(DISTRICT_ID) != null
					&& !(request.getParameter(DISTRICT_ID).equals(""))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
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

		List codeList = new ArrayList();
		List nameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			codeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			nameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((codeList.size() == 0 || codeList == null)
				&& (nameList.size() == 0 || nameList == null)) {
			phMasParliyamentAssembly.setCode(code);
			phMasParliyamentAssembly.setName(name);
			if (districtId != 0) {
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				phMasParliyamentAssembly.setDistrict(masDistrict);
			}
			phMasParliyamentAssembly.setStatus("Y");
			Users users = new Users();
			users.setId(userId);
			phMasParliyamentAssembly.setCategory("P");
			phMasParliyamentAssembly.setLastChgBy(users);
			phMasParliyamentAssembly.setLastChgDate(currentDate);
			phMasParliyamentAssembly.setLastChgTime(currentTime);
			Map<String, Object> parliyamentMap = new HashMap<String, Object>();

			log.info("phMasParliyamentAssembly"
					+ phMasParliyamentAssembly);

			parliyamentMap.put("phMasParliyamentAssembly",
					phMasParliyamentAssembly);
			parliyamentMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addParliyament(parliyamentMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((codeList.size() != 0 || codeList != null)
				|| (nameList.size() != 0) || nameList != null) {
			if ((codeList.size() != 0 || codeList != null)
					&& (nameList.size() == 0 || nameList == null)) {
				message = "Parliyament Code already exists.";
			} else if ((nameList.size() != 0 || nameList != null)
					&& (codeList.size() == 0 || codeList == null)) {
				message = "Parliyament Name already exists.";
			} else if ((codeList.size() != 0 || codeList != null)
					&& (nameList.size() != 0 || nameList != null)) {
				message = "Parliyament Code and Parliyament Name exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showParliyament();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "parliyament";
		title = "Add Parliyament";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editParliyament(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		String code = "";
		String name = "";
		int districtId = 0;
		int parliyamentId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(DISTRICT_ID) != null
					&& !(request.getParameter(DISTRICT_ID).equals(""))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				parliyamentId = Integer.parseInt(request
						.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				code = request.getParameter(CODE);
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

			generalMap.put("id", parliyamentId);
			generalMap.put("code", code);
			generalMap.put("name", name);
			generalMap.put("districtId", districtId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService
					.editParliyament(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showParliyament();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "parliyament";
		title = "Edit Parliyament";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchParliyament(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String code = null;
		String name = null;
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
			code = searchField;
			name = null;

		} else {
			code = null;
			name = searchField;
		}
		map = generalMasterHandlerService.searchParliyament(code, name);

		jsp = "parliyament";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		map.put("name", name);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteParliyament(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int parliyamentId = 0;
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
			parliyamentId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteParliyament(
				parliyamentId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showParliyamentJsp";

		try {
			map = generalMasterHandlerService.showParliyament();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "parliyament";
		title = "delete Parliyament";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ---------------------------------------
	// Assembly----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showAssemblyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showAssembly();
		String jsp = "assembly";
		jsp += ".jsp";
		title = "Assembly";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAssembly(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		PhMasParliyamentAssembly phMasParliyamentAssembly = new PhMasParliyamentAssembly();
		int districtId = 0;
		int parliyamentId = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		HttpSession session = request.getSession();
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

			if (request.getParameter(DISTRICT_ID) != null
					&& !(request.getParameter(DISTRICT_ID).equals(""))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
			}
			if (request.getParameter("parliyamentId") != null
					&& !(request.getParameter("parliyamentId").equals(""))) {
				parliyamentId = Integer.parseInt(request
						.getParameter("parliyamentId"));
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

		List codeList = new ArrayList();
		List nameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			codeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			nameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((codeList.size() == 0 || codeList == null)
				&& (nameList.size() == 0 || nameList == null)) {
			phMasParliyamentAssembly.setCode(code);
			phMasParliyamentAssembly.setName(name);
			if (districtId != 0) {
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				phMasParliyamentAssembly.setDistrict(masDistrict);
			}

			if (parliyamentId != 0) {
				PhMasParliyamentAssembly parliyament = new PhMasParliyamentAssembly();
				parliyament.setId(parliyamentId);
				phMasParliyamentAssembly.setParliyament(parliyament);
			}
			phMasParliyamentAssembly.setStatus("Y");
			Users users = new Users();
			users.setId(userId);
			phMasParliyamentAssembly.setCategory("A");
			phMasParliyamentAssembly.setLastChgBy(users);
			phMasParliyamentAssembly.setLastChgDate(currentDate);
			phMasParliyamentAssembly.setLastChgTime(currentTime);
			Map<String, Object> parliyamentMap = new HashMap<String, Object>();

			log.info("phMasParliyamentAssembly"
					+ phMasParliyamentAssembly);

			parliyamentMap.put("phMasParliyamentAssembly",
					phMasParliyamentAssembly);
			parliyamentMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addAssembly(parliyamentMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((codeList.size() != 0 || codeList != null)
				|| (nameList.size() != 0) || nameList != null) {
			if ((codeList.size() != 0 || codeList != null)
					&& (nameList.size() == 0 || nameList == null)) {
				message = "Assembly Code already exists.";
			} else if ((nameList.size() != 0 || nameList != null)
					&& (codeList.size() == 0 || codeList == null)) {
				message = "Assembly Name already exists.";
			} else if ((codeList.size() != 0 || codeList != null)
					&& (nameList.size() != 0 || nameList != null)) {
				message = "Assembly Code and Assembly Name exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showAssembly();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "assembly";
		title = "Add Assembly";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editAssembly(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String code = "";
		String name = "";
		int districtId = 0;
		int parliyamentId = 0;
		int assemblyId = 0;
		Date changedDate = null;
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(DISTRICT_ID) != null
					&& !(request.getParameter(DISTRICT_ID).equals(""))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
			}
			if (request.getParameter("parliyamentId") != null
					&& !(request.getParameter("parliyamentId").equals(""))) {
				parliyamentId = Integer.parseInt(request
						.getParameter("parliyamentId"));
			}

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				assemblyId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				code = request.getParameter(CODE);
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

			generalMap.put("id", assemblyId);
			generalMap.put("parliyamentId", parliyamentId);
			generalMap.put("code", code);
			generalMap.put("name", name);
			generalMap.put("districtId", districtId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService.editAssembly(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showAssembly();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "assembly";
		title = "Edit Assembly";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAssembly(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String code = null;
		String name = null;
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
			code = searchField;
			name = null;

		} else {
			code = null;
			name = searchField;
		}
		map = generalMasterHandlerService.searchAssembly(code, name);

		jsp = "assembly";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("code", code);
		map.put("name", name);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAssembly(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int assemblyId = 0;
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
			assemblyId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteAssembly(assemblyId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showAssemblyJsp";

		try {
			map = generalMasterHandlerService.showAssembly();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "assembly";
		title = "delete Assembly";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ---------------------------------------
	// CharityType----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showCharityTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showCharityType();
		String jsp = "charityType";
		jsp += ".jsp";
		title = "CharityType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addCharityType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasCharityType masCharityType = new MasCharityType();
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
			masCharityType.setCharityTypeCode(code);
			masCharityType.setCharityTypeName(name);

			masCharityType.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			masCharityType.setLastChgBy(users);
			masCharityType.setLastChgDate(currentDate);
			masCharityType.setLastChgTime(currentTime);
			Map<String, Object> charityTypeMap = new HashMap<String, Object>();

			log.info("masCharityType" + masCharityType);

			charityTypeMap.put("masCharityType", masCharityType);
			charityTypeMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addCharityType(charityTypeMap);

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
				message = "CharityType Code already exists.";
			} else if ((charityTypeNameList.size() != 0 || charityTypeNameList != null)
					&& (charityTypeCodeList.size() == 0 || charityTypeCodeList == null)) {
				message = "CharityType Name already exists.";
			} else if ((charityTypeCodeList.size() != 0 || charityTypeCodeList != null)
					&& (charityTypeNameList.size() != 0 || charityTypeNameList != null)) {
				message = "CharityType Code and CharityType exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showCharityType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "charityType";
		title = "Add CharityType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editCharityType(HttpServletRequest request,
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
			dataUpdated = generalMasterHandlerService
					.editCharityType(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showCharityType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "charityType";
		title = "Edit CharityType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchCharityType(HttpServletRequest request,
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
		map = generalMasterHandlerService.searchCharityType(charityTypeCode,
				charityTypeName);

		jsp = "charityType";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("charityTypeCode", charityTypeCode);
		map.put("charityTypeName", charityTypeName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteCharityType(HttpServletRequest request,
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
		dataDeleted = generalMasterHandlerService.deleteCharityType(
				charityTypeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showCharityTypeJsp";

		try {
			map = generalMasterHandlerService.showCharityType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "charityType";
		title = "delete CharityType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView showGroupJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showGroupJsp();
		log.info("map Sise" + map.size());
		String jsp = GROUP_JSP;
		jsp += ".jsp";
		title = "Group";
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasSpecialityGroup masGroup = new MasSpecialityGroup();
		HttpSession session = request.getSession();
		int majorCategoryId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Integer userId = (Integer) session.getAttribute("userId");
		String display = "";
		int heading = 0;

		try {
			if (session.getAttribute("userId") != null) {
				userId = (Integer) session.getAttribute("userId");

			}

			if (request.getParameter(CODE) != null
					&& !"".equals(request.getParameter(CODE))) {
				code = request.getParameter(CODE);
				log.info("CODE" + request.getParameter(CODE));
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !"".equals(request.getParameter(SEARCH_NAME))) {
				name = request.getParameter(SEARCH_NAME);
				log.info("SEARCH_NAME"
						+ request.getParameter(SEARCH_NAME));
			}

			if (request.getParameter(COUNTRY_ID) != null
					&& !"".equals(request.getParameter(COUNTRY_ID))) {
				majorCategoryId = Integer.valueOf(request
						.getParameter(COUNTRY_ID));
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
			
			if (request.getParameter("heading") != null && !request.getParameter("heading").equals(0)) {
				heading =Integer.parseInt(request.getParameter("heading"));
			}
			
			if (request.getParameter("display") != null && !request.getParameter("display").equals("")) {
				display = request.getParameter("display");
			}else{
				display = "n";
			}

			generalMap.put("code", code);
			generalMap.put("name", name);

			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("userId", userId);
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

		List groupCodeList = new ArrayList();
		List groupNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			groupCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			groupNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((groupCodeList.size() == 0 || groupCodeList == null)
				&& (groupNameList.size() == 0 || groupNameList == null)) {

			masGroup.setSpGroupCode(code);
			masGroup.setSpGroupName(name);

			masGroup.setStatus("y");
			Users users = new Users();
			users.setId(userId);

			masGroup.setLastChgBy(users);
			masGroup.setLastChgDate(currentDate);
			masGroup.setLastChgTime(currentTime);
			
			if(!display.equals("")){
				masGroup.setDisplay(display);
			}
			if(heading != 0){
				MasSpecialityHeading masSpecialityHeading = new MasSpecialityHeading();
				masSpecialityHeading.setId(heading);
				masGroup.setSpHeading(masSpecialityHeading);
			}

			successfullyAdded = generalMasterHandlerService.addGroup(masGroup);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((groupCodeList.size() != 0 || groupCodeList != null)
				|| (groupNameList.size() != 0) || groupNameList != null) {
			if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() == 0 || groupNameList == null)) {
				message = "Group Code already exists.";
			} else if ((groupNameList.size() != 0 || groupNameList != null)
					&& (groupCodeList.size() == 0 || groupCodeList == null)) {
				message = "Group Name already exists.";
			} else if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() != 0 || groupNameList != null)) {
				message = "Group Code and State exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showGroupJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = GROUP_JSP;
		title = "Add Group";
		jsp += ".jsp";
		// map.put("pageNo",
		// Integer.parseInt(request.getParameter("pageNoEdit")));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchGroup(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String groupCode = null;
		String groupName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			groupCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			groupName = request.getParameter(SEARCH_NAME);
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
			log.info("searchRadio" + searchRadio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			groupCode = searchField;
			groupName = null;
		} else {
			groupCode = null;
			groupName = searchField;
		}
		map = generalMasterHandlerService.searchGroup(groupCode, groupName);
		jsp = GROUP_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("groupCode", groupCode);
		map.put("groupName", groupName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editGroupToDatabase(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String groupCode = "";
		String groupName = "";
		int groupId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		int userId = 0;
		String display = "";

		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			groupId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			groupCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			groupName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
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
		if (request.getParameter("display") != null && !request.getParameter("display").equals("")) {
			display = request.getParameter("display");
		}else{
			display = "n";
		}
		int heading = 0;
		if (request.getParameter("heading") != null && !request.getParameter("heading").equals(0)) {
			heading =Integer.parseInt(request.getParameter("heading"));
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("heading", heading);
		generalMap.put("display", display);
		generalMap.put("id", groupId);
		generalMap.put("groupCode", groupCode);
		generalMap.put("name", groupName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBloodGroupNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;

		if (existingBloodGroupNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editGroupToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBloodGroupNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showGroupJsp";
		try {
			map = generalMasterHandlerService.showGroupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = GROUP_JSP;
		title = "Update Group";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int grpId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId = 0;
		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			grpId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		generalMap.put("userId", userId);

		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService
				.deleteGroup(grpId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showGroupJsp";
		try {
			map = generalMasterHandlerService.showGroupJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = GROUP_JSP;
		title = "Delete Group";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ------------------------PARAMETER MASTER
	// --------------------------------------------

	public ModelAndView showParameterJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showParameterJsp();
		log.info("map Sise" + map.size());
		String jsp = PARAMETER_MASTER;
		jsp += ".jsp";
		title = "PARAMETER";
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasSpecialityParameter masParameter = new MasSpecialityParameter();

		HttpSession session = request.getSession();

		int majorCategoryId = 0;
		String changedBy = "";
		String valueType = "";
		String img = " ";
		String common = " ";

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		Date currentDate = new Date();
		Integer userId = (Integer) session.getAttribute("userId");

		try {
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
				log.info("CODE" + request.getParameter(CODE));
			}

			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
				log.info("SEARCH_NAME"
						+ request.getParameter(SEARCH_NAME));
			}

			if (request.getParameter(VALUE_TYPE) != null) {
				valueType = request.getParameter(VALUE_TYPE);
				log.info("VALUE_TYPE"
						+ request.getParameter(VALUE_TYPE));
			}
			if (request.getParameter(IMG_REQ) != null) {
				img = request.getParameter(IMG_REQ);
				log.info("IMG_REQ" + request.getParameter(IMG_REQ));
			}
			if (request.getParameter(COMMON) != null) {
				common = request.getParameter(COMMON);
				log.info("COMMON" + request.getParameter(COMMON));
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

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		List groupCodeList = new ArrayList();
		List groupNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			groupCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			groupNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((groupCodeList.size() == 0 || groupCodeList == null)
				&& (groupNameList.size() == 0 || groupNameList == null)) {

			masParameter.setSpParameterCode(code);
			masParameter.setSpParameterName(name);
			masParameter.setValueType(valueType);
			masParameter.setImageReq(img);
			masParameter.setId(userId);
			masParameter.setCommon(common);
			Users user = new Users();
			user.setId(userId);

			masParameter.setLastChgBy(user);
			masParameter.setLastChgDate(currentDate);
			masParameter.setLastChgTime(currentTime);
			masParameter.setStatus("y");

			successfullyAdded = generalMasterHandlerService
					.addParameter(masParameter);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((groupCodeList.size() != 0 || groupCodeList != null)
				|| (groupNameList.size() != 0) || groupNameList != null) {
			if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() == 0 || groupNameList == null)) {
				message = "Group Code already exists.";
			} else if ((groupNameList.size() != 0 || groupNameList != null)
					&& (groupCodeList.size() == 0 || groupCodeList == null)) {
				message = "Group Name already exists.";
			} else if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() != 0 || groupNameList != null)) {
				message = "Group Code and State exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showParameterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PARAMETER_MASTER;
		title = "Add Group";
		jsp += ".jsp";
		// map.put("pageNo",
		// Integer.parseInt(request.getParameter("pageNoEdit")));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchParameter(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String pameterCode = null;
		String parameterName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			pameterCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			parameterName = request.getParameter(SEARCH_NAME);
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
			log.info("searchRadio" + searchRadio);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			pameterCode = searchField;
			parameterName = null;
		} else {
			pameterCode = null;
			parameterName = searchField;
		}
		log.info(pameterCode + "    " + parameterName);
		map = generalMasterHandlerService.searchParameter(pameterCode,
				parameterName);
		jsp = PARAMETER_MASTER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pameterCode", pameterCode);
		map.put("parameterName", parameterName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editParameter(HttpServletRequest request,
			HttpServletResponse response) {
		

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String parameterCode = "";
		String parameterName = "";
		String valueType = "";
		String imageReq = "";
		String common = "";

		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = new Date();

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			parameterCode = request.getParameter(CODE);

		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			parameterName = request.getParameter(SEARCH_NAME);

			log.info("parameterName "
					+ request.getParameter(SEARCH_NAME));
		}

		log.info("parameterName "
				+ request.getParameter(SEARCH_NAME));

		if (request.getParameter(VALUE_TYPE) != null) {
			valueType = request.getParameter(VALUE_TYPE);
			log.info("VALUE_TYPE" + request.getParameter(VALUE_TYPE));
		}
		if (request.getParameter(IMG_REQ) != null) {
			imageReq = request.getParameter(IMG_REQ);
			log.info("IMG_REQ" + request.getParameter(IMG_REQ));
		}
		if (request.getParameter(COMMON) != null) {
			common = request.getParameter(COMMON);
			log.info("COMMON" + request.getParameter(COMMON));
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
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

		generalMap.put("id", id);
		generalMap.put("parameterCode", parameterCode);
		generalMap.put("parameterName", parameterName);
		generalMap.put("valueType", valueType);
		generalMap.put(" imageReq", imageReq);
		generalMap.put("common", common);

		generalMap.put("changedBy", changedBy);

		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBloodGroupNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;

		if (existingBloodGroupNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editParameterToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBloodGroupNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showParameter";
		try {
			map = generalMasterHandlerService.showParameterJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PARAMETER_MASTER;
		title = "Update Parameter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int grpId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId = 0;
		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");

		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			grpId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		generalMap.put("userId", userId);

		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteParameter(grpId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showParameterJsp";
		try {
			map = generalMasterHandlerService.showParameterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PARAMETER_MASTER;
		title = "Delete Parameter";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ---------------------------- Group Parameter Master
	// -----------------------------------------

	public ModelAndView showGroupParaMasterJSP(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();

		if (request.getParameter("searchField") != null
				&& request.getParameter("searchField") != "") {
			details.put("groupName", request.getParameter("searchField"));
		}
		map = generalMasterHandlerService.showGroupParaMasterJSP(details);

		String jsp = GRP_PARA_MASTER;
		jsp += ".jsp";
		title = "Group Parameter";
		map.put("contentJsp", jsp);
		
		map.put("pageNo", 1);
		map.put("title", title);
		// map.put("mapForSpGroupParameterT", mapForSpGroupParameterT);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addGroupParaMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasSpecialtyGroupParameter spParaM = new MasSpecialtyGroupParameter();
		MasSpecialityGroup masGroup = new MasSpecialityGroup();
		MasSpecialityParameter masSpPara = new MasSpecialityParameter();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String grpMaster = "";
		int id = 0;
		String changedBy = "";
		String paraMastr = "";

		Map<String, Object> listMap = new HashMap<String, Object>();

		Date currentDate = new Date();
		int userId = 0;

		paraMastr = request.getParameter("paraMastr");


		try {
			if (session.getAttribute("userId") != null) {
				userId = (Integer) session.getAttribute("userId");
			}

			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
				
			}

			if (request.getParameter("grpMaster") != null) {
				grpMaster = request.getParameter("grpMaster");
				
			}

			if (request.getParameter("paraMastr") != null) {
				paraMastr = request.getParameter("paraMastr");
				
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

			generalMap.put("grpMaster", grpMaster);
			generalMap.put("paraMastr", paraMastr);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", currentDate);
			generalMap.put("userId", userId);
			generalMap.put("currentTime", currentTime);

		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean successfullyAdded = false;
		Map m = new HashMap();
		m.put("generalMap", generalMap);

		successfullyAdded = generalMasterHandlerService.addGroupParaMaster(m);

		if (successfullyAdded) {
			message = "Record Added Successfully !";
		} else {

			message = "Try Again Duplicate Record!!";
		}

		Map<String, Object> details = new HashMap<String, Object>();
		try {
			map = generalMasterHandlerService.showGroupParaMasterJSP(details);

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * List<SpGroupParameterT>
		 * groupParameterTs=(List<SpGroupParameterT>)map.
		 * get("spGroupParameterT"); Map<Integer, List<SpGroupParameterT>>
		 * mapForSpGroupParameterT=new HashMap<Integer,
		 * List<SpGroupParameterT>>();
		 * 
		 * for(SpGroupParameterT groupParameterT:groupParameterTs ){
		 * 
		 * if(mapForSpGroupParameterT.get(groupParameterT.getGroupParameterM().getId
		 * ())!=null){ List<SpGroupParameterT>
		 * subGroupT1=mapForSpGroupParameterT
		 * .get(groupParameterT.getGroupParameterM().getId());
		 * subGroupT1.add(groupParameterT);
		 * mapForSpGroupParameterT.put(groupParameterT
		 * .getGroupParameterM().getId(), subGroupT1); }else{
		 * List<SpGroupParameterT> subGroupT=new ArrayList<SpGroupParameterT>();
		 * subGroupT.add(groupParameterT);
		 * mapForSpGroupParameterT.put(groupParameterT
		 * .getGroupParameterM().getId(), subGroupT); }
		 * 
		 * 
		 * }
		 */
		jsp = GRP_PARA_MASTER;
		title = "Group Parameter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		// map.put("mapForSpGroupParameterT", mapForSpGroupParameterT);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editGroupParaMaster(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String grpMaster = "";
		String changedBy = "";
		String paraMeterVale = " ";
		int userId = (Integer) session.getAttribute("userId");

		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		int id = 0;

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter("grpMaster") != null) {
			grpMaster = request.getParameter("grpMaster");
		}

		if (request.getParameter("paraMastr") != null
				&& !(request.getParameter("paraMastr").equals(""))) {
			paraMeterVale = request.getParameter("paraMastr");

		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
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

		generalMap.put("id", id);
		generalMap.put("grpMaster", grpMaster);
		generalMap.put("paraMeterVale", paraMeterVale);
		generalMap.put("name", grpMaster);
		generalMap.put("changedBy", changedBy);
		generalMap.put("userId", userId);

		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBloodGroupNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;

		if (existingBloodGroupNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editGroupParaMaster(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBloodGroupNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showParameter";
		try {
			map = generalMasterHandlerService
					.showGroupParaMasterJSP(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = GRP_PARA_MASTER;
		title = "Update Parameter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteGroupParaMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int id = 0;
		String message = null;
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService.deleteGroupParaMaster(id,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showGroupParaMasterJSP";

		Map<String, Object> details = new HashMap<String, Object>();

		try {
			map = generalMasterHandlerService.showGroupParaMasterJSP(details);

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * List<SpGroupParameterT>
		 * groupParameterTs=(List<SpGroupParameterT>)map.
		 * get("spGroupParameterT"); Map<Integer, List<SpGroupParameterT>>
		 * mapForSpGroupParameterT=new HashMap<Integer,
		 * List<SpGroupParameterT>>();
		 * 
		 * for(SpGroupParameterT groupParameterT:groupParameterTs ){
		 * 
		 * if(mapForSpGroupParameterT.get(groupParameterT.getGroupParameterM().getId
		 * ())!=null){ List<SpGroupParameterT>
		 * subGroupT1=mapForSpGroupParameterT
		 * .get(groupParameterT.getGroupParameterM().getId());
		 * subGroupT1.add(groupParameterT);
		 * mapForSpGroupParameterT.put(groupParameterT
		 * .getGroupParameterM().getId(), subGroupT1); }else{
		 * List<SpGroupParameterT> subGroupT=new ArrayList<SpGroupParameterT>();
		 * subGroupT.add(groupParameterT);
		 * mapForSpGroupParameterT.put(groupParameterT
		 * .getGroupParameterM().getId(), subGroupT); }
		 * 
		 * 
		 * }
		 */

		jsp = GRP_PARA_MASTER;
		title = "Group Parameter";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		// map.put("mapForSpGroupParameterT", mapForSpGroupParameterT);
		return new ModelAndView("index", "map", map);

	}

	// ---------------------------- ------------------------------------------
	/*
	 * public ModelAndView showDepartWiseGrpMaster(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Map<String, Object> details = new
	 * HashMap<String, Object>();
	 * 
	 * if(request.getParameter("searchField")!=null &&
	 * request.getParameter("searchField")!=""){ details.put("depName",
	 * request.getParameter("searchField"));
	 * 
	 * }
	 * 
	 * map = generalMasterHandlerService.showDepartWiseGrpMaster(details);
	 * 
	 * List<SpDeptGroupT>
	 * deptGroupTs=(List<SpDeptGroupT>)map.get("deptGroupTs");
	 * log.info("------------");
	 * log.info("deptGroupTs"+deptGroupTs.size());
	 * 
	 * Map<Integer, List<SpDeptGroupT>> mapForSpDepGroupPaT=new HashMap<Integer,
	 * List<SpDeptGroupT>>();
	 * 
	 * for(SpDeptGroupT spDpgroupT:deptGroupTs ){
	 * if(mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId())!=null){
	 * 
	 * List<SpDeptGroupT>
	 * subGroupT1=mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId());
	 * subGroupT1.add(spDpgroupT);
	 * mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(), subGroupT1);
	 * 
	 * 
	 * }else{
	 * 
	 * List<SpDeptGroupT> subGroupT=new ArrayList<SpDeptGroupT>();
	 * subGroupT.add(spDpgroupT);
	 * mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(), subGroupT); }
	 * 
	 * }
	 * 
	 * int i=0;
	 * 
	 * for(SpDeptGroupT spDepartGroupT:deptGroupTs ){
	 * if(i!=spDepartGroupT.getDeptGroupM().getId()){ log.info("ABC");
	 * i=spDepartGroupT.getDeptGroupM().getId();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * String jsp = DEPARTMENT_GROUP; jsp += ".jsp"; title =
	 * "SpDepartParameter"; map.put("contentJsp", jsp); map.put("pageNo", 1);
	 * map.put("title", title); map.put("mapForSpDepGroupPaT",
	 * mapForSpDepGroupPaT); return new ModelAndView("index", "map", map);
	 * 
	 * }
	 * 
	 * public ModelAndView addDepartmentGrPara(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * log.info("hit  addDepartmentGrPara");
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>(); SpDeptGroupM
	 * deptGroupM=new SpDeptGroupM(); MasSpecialityGroup masGroup = new
	 * MasSpecialityGroup(); MasDepartment masDepartment =new MasDepartment();
	 * 
	 * HttpSession session=request.getSession();
	 * 
	 * 
	 * String grpName =" "; String paraMeterVales[]=null; String dpartName=" ";
	 * 
	 * int id = 0; String changedBy = "";
	 * 
	 * 
	 * 
	 * Map<String, Object> listMap = new HashMap<String, Object>(); Map<String,
	 * Object> generalMap = new HashMap<String, Object>(); Date currentDate =
	 * new Date(); Users userId= (Users) session.getAttribute("users");
	 * 
	 * paraMeterVales=request.getParameterValues("paraMeterVales");
	 * 
	 * log.info("paraMeterVales"+paraMeterVales.length);
	 * log.info("grpName   "+request.getParameter("grpName"));
	 * 
	 * 
	 * try {
	 * 
	 * if (request.getParameter(SEARCH_NAME) != null) { name =
	 * request.getParameter(SEARCH_NAME);
	 * log.info("SEARCH_NAME"+request.getParameter(SEARCH_NAME)); }
	 * 
	 * if (request.getParameter("dpartName") != null) { dpartName
	 * =request.getParameter("dpartName");
	 * log.info("dpartName"+request.getParameter("dpartName")); }
	 * 
	 * 
	 * if (request.getParameter("grpName") != null) { grpName
	 * =request.getParameter("grpName");
	 * log.info("grpName"+request.getParameter("grpName")); }
	 * 
	 * 
	 * if (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) { changedBy =
	 * request.getParameter(CHANGED_BY); } if
	 * (request.getParameter(CHANGED_DATE) != null &&
	 * !(request.getParameter(CHANGED_DATE).equals(""))) { currentDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request .getParameter(CHANGED_DATE)); } if
	 * (request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))) { currentTime =
	 * request.getParameter(CHANGED_TIME); } if (request.getParameter("title")
	 * != null) { title = request.getParameter("title"); } if
	 * (request.getParameter("pojoName") != null) { pojoName =
	 * request.getParameter("pojoName");
	 * 
	 * } if (request.getParameter("pojoPropertyName") != null) {
	 * pojoPropertyName = request.getParameter("pojoPropertyName");
	 * 
	 * } if (request.getParameter("pojoPropertyCode") != null) {
	 * pojoPropertyCode = request.getParameter("pojoPropertyCode");
	 * 
	 * }
	 * 
	 * generalMap.put("currentDate", currentDate); generalMap.put("currentTime",
	 * currentTime);
	 * 
	 * generalMap.put("pojoPropertyName", pojoPropertyName);
	 * generalMap.put("pojoPropertyCode", pojoPropertyCode);
	 * generalMap.put("pojoName", pojoName); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * try {
	 * 
	 * listMap = commonMasterHandlerService
	 * .checkForExistingMasters(generalMap); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * List groupCodeList = new ArrayList(); List groupNameList = new
	 * ArrayList();
	 * 
	 * if (listMap.get("duplicateGeneralCodeList") != null) { groupCodeList =
	 * (List) listMap.get("duplicateGeneralCodeList");
	 * 
	 * } if (listMap.get("duplicateGeneralNameList") != null) { groupNameList =
	 * (List) listMap.get("duplicateGeneralNameList");
	 * 
	 * } boolean successfullyAdded = false;
	 * 
	 * if ((groupCodeList.size() == 0 || groupCodeList == null) &&
	 * (groupNameList.size() == 0 || groupNameList == null)) {
	 * 
	 * 
	 * 
	 * 
	 * masGroup.setId(Integer.parseInt(""+grpName));
	 * masDepartment.setId(Integer.parseInt(""+dpartName));
	 * 
	 * deptGroupM.setSpGroup(masGroup); deptGroupM.setDepartment(masDepartment);
	 * deptGroupM.setLastChgBy(userId); deptGroupM.setLastChgDate(currentDate);
	 * deptGroupM.setLastChgTime(currentTime); deptGroupM.setStatus("Y");
	 * 
	 * Map m = new HashMap();
	 * 
	 * m.put("deptGroupM", deptGroupM); m.put("paraMeterVales", paraMeterVales);
	 * 
	 * successfullyAdded = generalMasterHandlerService.addDepartmentGrPara(m);
	 * 
	 * if (successfullyAdded) { message = "Record Added Successfully !!"; } else
	 * { message = "Try Again !!"; }
	 * 
	 * } else if ((groupCodeList.size() != 0 || groupCodeList != null) ||
	 * (groupNameList.size() != 0) || groupNameList != null) { if
	 * ((groupCodeList.size() != 0 || groupCodeList != null) &&
	 * (groupNameList.size() == 0 || groupNameList == null)) { message =
	 * "Group Code already exists."; } else if ((groupNameList.size() != 0 ||
	 * groupNameList != null) && (groupCodeList.size() == 0 || groupCodeList ==
	 * null)) { message = "Group Name already exists."; } else if
	 * ((groupCodeList.size() != 0 || groupCodeList != null) &&
	 * (groupNameList.size() != 0 || groupNameList != null)) { message =
	 * "Group Code and State exist."; }
	 * 
	 * 
	 * } Map<String, Object> details = new HashMap<String, Object>();
	 * 
	 * 
	 * try { map = generalMasterHandlerService.showDepartWiseGrpMaster(details);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * List<SpDeptGroupT>
	 * deptGroupTs=(List<SpDeptGroupT>)map.get("deptGroupTs");
	 * log.info("------------");
	 * log.info("deptGroupTs"+deptGroupTs.size());
	 * 
	 * Map<Integer, List<SpDeptGroupT>> mapForSpDepGroupPaT=new HashMap<Integer,
	 * List<SpDeptGroupT>>();
	 * 
	 * for(SpDeptGroupT spDpgroupT:deptGroupTs ){
	 * if(mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId())!=null){
	 * 
	 * List<SpDeptGroupT>
	 * subGroupT1=mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId());
	 * subGroupT1.add(spDpgroupT);
	 * mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(), subGroupT1);
	 * 
	 * 
	 * }else{
	 * 
	 * List<SpDeptGroupT> subGroupT=new ArrayList<SpDeptGroupT>();
	 * subGroupT.add(spDpgroupT);
	 * mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(), subGroupT); }
	 * } jsp = DEPARTMENT_GROUP; title = "SpDepartParameter"; jsp += ".jsp";
	 * //map.put("pageNo",
	 * Integer.parseInt(request.getParameter("pageNoEdit")));
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("url", url);
	 * map.put("message", message); map.put("mapForSpDepGroupPaT",
	 * mapForSpDepGroupPaT); return new ModelAndView("index", "map", map);
	 * 
	 * }
	 * 
	 * 
	 * public ModelAndView deleteDepartWiseGrpMaster(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * 
	 * int id = 0; String message = null; String changedBy = ""; String
	 * changedTime = ""; Date changedDate = null; String flag = "";
	 * 
	 * 
	 * if (request.getParameter("flag") != null) { flag =
	 * request.getParameter("flag"); generalMap.put("flag", flag); } if
	 * (request.getParameter(COMMON_ID) != null &&
	 * !(request.getParameter(COMMON_ID).equals(""))) { id =
	 * Integer.parseInt(request.getParameter(COMMON_ID)); } if
	 * (request.getParameter("title") != null) { title =
	 * request.getParameter("title"); }
	 * 
	 * if (request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))) { changedBy =
	 * request.getParameter(CHANGED_BY); }
	 * 
	 * changedDate = new Date(); changedTime = (String)
	 * HMSUtil.getCurrentDateAndTime().get( "currentTime");
	 * 
	 * generalMap.put("changedBy", changedBy); generalMap.put("currentDate",
	 * changedDate); generalMap.put("currentTime", changedTime);
	 * 
	 * 
	 * boolean dataDeleted = false; dataDeleted =
	 * generalMasterHandlerService.deleteDepartWiseGrpMaster(id,generalMap); if
	 * (dataDeleted == true) { message =
	 * "Record is InActivated successfully !!"; }
	 * 
	 * else { message = "Record is Activated successfully !!"; } url =
	 * "/hms/hms/generalMaster?method=showDepartWiseGrpMaster";
	 * 
	 * Map<String, Object> details = new HashMap<String, Object>();
	 * 
	 * try { map = generalMasterHandlerService.showDepartWiseGrpMaster(details);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } List<SpDeptGroupT>
	 * deptGroupTs=(List<SpDeptGroupT>)map.get("deptGroupTs");
	 * log.info("------------");
	 * log.info("deptGroupTs"+deptGroupTs.size());
	 * 
	 * Map<Integer, List<SpDeptGroupT>> mapForSpDepGroupPaT=new HashMap<Integer,
	 * List<SpDeptGroupT>>();
	 * 
	 * for(SpDeptGroupT spDpgroupT:deptGroupTs ){
	 * if(mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId())!=null){
	 * 
	 * List<SpDeptGroupT>
	 * subGroupT1=mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM().getId());
	 * subGroupT1.add(spDpgroupT);
	 * mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(), subGroupT1);
	 * 
	 * 
	 * }else{
	 * 
	 * List<SpDeptGroupT> subGroupT=new ArrayList<SpDeptGroupT>();
	 * subGroupT.add(spDpgroupT);
	 * mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(), subGroupT); }
	 * }
	 * 
	 * jsp = DEPARTMENT_GROUP; title = "Group Parameter"; jsp += ".jsp";
	 * 
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("url", url);
	 * map.put("message", message); map.put("mapForSpDepGroupPaT",
	 * mapForSpDepGroupPaT); return new ModelAndView("index", "map", map);
	 * 
	 * }
	 */

	// ----------------------- Committee -------------------------------------

	public ModelAndView showCommitteeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showCommitteeJsp();
		// log.info("map Sise"+map.size());
		String jsp = COMMITTEE;
		jsp += ".jsp";
		title = "Committee";
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addCommittee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrCommitteeHeader hrCommHed = new HrCommitteeHeader();
		MasHospital masHospital = new MasHospital();

		HttpSession session = request.getSession();
		String code = " ";
		int hospitalId = 0;
		String userId = " ";
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		try {

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				code = request.getParameter(CODE);
				log.info("CODE" + request.getParameter(CODE));
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				name = request.getParameter(SEARCH_NAME);
				log.info("SEARCH_NAME"
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

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List groupCodeList = new ArrayList();
		List groupNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			groupCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			groupNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((groupCodeList.size() == 0 || groupCodeList == null)
				&& (groupNameList.size() == 0 || groupNameList == null)) {
			if (!code.equals("")) {

				masHospital.setId(hospitalId);

				hrCommHed.setCommitteeCode(code);
				hrCommHed.setCommitteeName(name);

				Users users = new Users();

				if (session.getAttribute("users") != null) {
					users = (Users) session.getAttribute("users");
				}

				hrCommHed.setLastChgBy(users);
				hrCommHed.setLastChgDate(currentDate);
				hrCommHed.setLastChgTime(currentTime);
				hrCommHed.setHospital(masHospital);
				hrCommHed.setStatus("y");

				successfullyAdded = generalMasterHandlerService
						.addCommittee(hrCommHed);
			}

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((groupCodeList.size() != 0 || groupCodeList != null)
				|| (groupNameList.size() != 0) || groupNameList != null) {
			if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() == 0 || groupNameList == null)) {
				message = "Group Code already exists.";
			} else if ((groupNameList.size() != 0 || groupNameList != null)
					&& (groupCodeList.size() == 0 || groupCodeList == null)) {
				message = "Group Name already exists.";
			} else if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() != 0 || groupNameList != null)) {
				message = "Group Code and Group Name exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showCommitteeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = COMMITTEE;
		title = "Committee";
		jsp += ".jsp";
		// map.put("pageNo",
		// Integer.parseInt(request.getParameter("pageNoEdit")));
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchCommittee(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String commCode = null;
		String commName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			commCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			commName = request.getParameter(SEARCH_NAME);
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
			commCode = searchField;
			commName = null;
		} else {
			commCode = null;
			commName = searchField;
		}
		map = generalMasterHandlerService.searchCommittee(commCode, commName);
		jsp = COMMITTEE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("groupCode", commCode);
		map.put("groupName", commName);
		return new ModelAndView("index", "map", map);
	}

	// -------------------- DEpartment Group Parameter
	// -----------------------------

	public ModelAndView showDepartmentGroupParameter(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();

		if (request.getParameter("searchField") != null
				&& request.getParameter("searchField") != "") {
			details.put("searchDeptId",Integer.parseInt(request.getParameter("searchField")));
		}
		if (request.getParameter("searchTemplate") != null
				&& request.getParameter("searchTemplate") != "") {
			details.put("searchTemplate",Integer.parseInt(request.getParameter("searchTemplate")));
		}
		int hospitalId=(Integer)request.getSession().getAttribute(HOSPITAL_ID);
		details.put("hospitalId", hospitalId);
		map = generalMasterHandlerService.showDepartmentGroupParameter(details);

		/*
		 * List<SpDeptGroupT>
		 * deptGroupTs=(List<SpDeptGroupT>)map.get("deptGroupTs");
		 * log.info("------------");
		 * //log.info("deptGroupTs"+deptGroupTs.size());
		 * 
		 * Map<Integer, List<SpDeptGroupT>> mapForSpDepGroupPaT=new
		 * HashMap<Integer, List<SpDeptGroupT>>();
		 * 
		 * for(SpDeptGroupT spDpgroupT:deptGroupTs ){
		 * if(mapForSpDepGroupPaT.get(
		 * spDpgroupT.getDeptGroupM().getId())!=null){
		 * 
		 * List<SpDeptGroupT>
		 * subGroupT1=mapForSpDepGroupPaT.get(spDpgroupT.getDeptGroupM
		 * ().getId()); subGroupT1.add(spDpgroupT);
		 * mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(),
		 * subGroupT1);
		 * 
		 * 
		 * }else{
		 * 
		 * List<SpDeptGroupT> subGroupT=new ArrayList<SpDeptGroupT>();
		 * subGroupT.add(spDpgroupT);
		 * mapForSpDepGroupPaT.put(spDpgroupT.getDeptGroupM().getId(),
		 * subGroupT); }
		 * 
		 * }
		 * 
		 * int i=0;
		 * 
		 * for(SpDeptGroupT spDepartGroupT:deptGroupTs ){
		 * if(i!=spDepartGroupT.getDeptGroupM().getId()){
		 * log.info("ABC"); i=spDepartGroupT.getDeptGroupM().getId();
		 * 
		 * }
		 * 
		 * }
		 */
		String jsp = DEPARTMENT_GROUP_PARAMETER;
		jsp += ".jsp";
		title = "DepartmentGroup";
		map.put("contentJsp", jsp);
		map.put("pageNo", 1);
		map.put("title", title);
		// map.put("mapForSpDepGroupPaT", mapForSpDepGroupPaT);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addDepartmentGroupParameter(HttpServletRequest request,
			HttpServletResponse response) {

		MasSpecialityDeptGroup masParameter = new MasSpecialityDeptGroup();
		SpGroupParameter spGrParameter = new SpGroupParameter();
		MasDepartment masDepartment = new MasDepartment();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int id = 0;
		String changedBy = "";
		String valueType = "";
		String img = "";
		String dpartName = "";
		String grpName = "";
		String template = "";
		String snoPa = "";
		String snoGp = "";
		String values[] = null;
		String defaultValues[]= null;
		String extraText[] = null;
		String parameter = "";
		String checkbox = "";
		
		String multipleSelection = "";
		String nadRequired = "";
		int noOfFields=0;
		String dateFields="";
		String grid = "";
		String simpleFormType = "";
		String mediumFormType = "";
		String complexFormType = "";
		

		Box box = HMSUtil.getBox(request);
		String fileName = null;
		String fileExtension = null;
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		Date currentDate = new Date();
		int userId = (Integer) session.getAttribute("userId");

		try {

			if (mrequest.getParameter(COMMON_ID) != null
					&& !(mrequest.getParameter(COMMON_ID).equals(""))) {
				id = Integer.parseInt(mrequest.getParameter(COMMON_ID));
			}

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}

			if (mrequest.getParameter("parameter") != null
					&& !"".equals(mrequest.getParameter("parameter"))) {
				parameter = mrequest.getParameter("parameter");
				log.info("parameter"
						+ mrequest.getParameter("parameter"));
			}
			if (mrequest.getParameter(CODE) != null) {
				code = mrequest.getParameter(CODE);
				log.info("CODE" + request.getParameter(CODE));
			}

			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
				log.info("SEARCH_NAME"
						+ request.getParameter(SEARCH_NAME));
			}

			if (mrequest.getParameter(CODE) != null) {
				dpartName = mrequest.getParameter(CODE);
				log.info("dpartName" + request.getParameter(CODE));
			}

			if (mrequest.getParameter("grpName") != null) {
				grpName = mrequest.getParameter("grpName");
				String[] grpNameArray = grpName.split(",");
				grpName = grpNameArray[0];

				log.info("grpName" + request.getParameter("grpName"));
			}

			if (mrequest.getParameter(VALUE_TYPE) != null
					&& !(mrequest.getParameter(VALUE_TYPE).equals(""))) {
				valueType = mrequest.getParameter(VALUE_TYPE);
				log.info("VALUE_TYPE"
						+ mrequest.getParameter(VALUE_TYPE));
			}
			if (mrequest.getParameter(IMG_REQ) != null) {
				img = mrequest.getParameter(IMG_REQ);
				log.info("IMG_REQ" + request.getParameter(IMG_REQ));
			}

			if (mrequest.getParameter(CHANGED_BY) != null
					&& !(mrequest.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (mrequest.getParameter("tempLate") != null
					&& !"".equals(mrequest.getParameter("tempLate"))) {
				template = mrequest.getParameter("tempLate");
			}
			String extraLov = "";
			if (mrequest.getParameter("extraLov") != null
					&& !"".equals(mrequest.getParameter("extraLov"))) {
				extraLov = mrequest.getParameter("extraLov");

			}
			log.info("valueType=in con ======"+valueType);
			log.info("extraLov==in con======"+extraLov);
			if (valueType.equalsIgnoreCase("LOV") ||   extraLov.equalsIgnoreCase("l")) {
				if (mrequest.getParameterValues("values") != null) {
					values = mrequest.getParameterValues("values");
					log.info("values======="+values);

					if (mrequest.getParameterValues("defaultValues") != null) {
						defaultValues = mrequest.getParameterValues("defaultValues");
					}
					
					if (mrequest.getParameterValues("extraText") != null) {
						extraText = mrequest.getParameterValues("extraText");
					}
				}
			}
			

			if (mrequest.getParameter("snoGp") != null
					&& !(mrequest.getParameter("snoGp").equals(""))) {
				snoGp = mrequest.getParameter("snoGp");
			}
			if (mrequest.getParameter("snoPa") != null
					&& !(mrequest.getParameter("snoPa").equals(""))) {
				snoPa = mrequest.getParameter("snoPa");
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
			if (mrequest.getParameter("checkbox") != null
					&& !"".equals(mrequest.getParameter("checkbox"))) {
				checkbox = mrequest.getParameter("checkbox");

			}
			
			
			String textFont = "";
			if (mrequest.getParameter("textFont") != null
					&& !"".equals(mrequest.getParameter("textFont"))) {
				textFont = mrequest.getParameter("textFont");

			}
			String textColor = "";
			if (mrequest.getParameter("textColor") != null
					&& !"".equals(mrequest.getParameter("textColor"))) {
				textColor = mrequest.getParameter("textColor");

			}
			
			String textSize = "";
			if (mrequest.getParameter("textSize") != null
					&& !"".equals(mrequest.getParameter("textSize"))) {
				textSize = mrequest.getParameter("textSize");

			}
			
			String validationValue = "";
			if (mrequest.getParameter("validationValue") != null
			&& !"".equals(mrequest.getParameter("validationValue"))) {
				validationValue = mrequest.getParameter("validationValue");

			}
			
			if (mrequest.getParameter("dateFields") != null
					&& !"".equals(mrequest.getParameter("dateFields"))) {
				dateFields = mrequest.getParameter("dateFields");

			}
			if (mrequest.getParameter("grid") != null
					&& !"".equals(mrequest.getParameter("grid"))) {
				grid = mrequest.getParameter("grid");

			}

			if (mrequest.getParameter("simpleFormType") != null
					&& !"".equals(mrequest.getParameter("simpleFormType"))) {
				simpleFormType = mrequest.getParameter("simpleFormType");

			}

			if (mrequest.getParameter("mediumFormType") != null
					&& !"".equals(mrequest.getParameter("mediumFormType"))) {
				mediumFormType = mrequest.getParameter("mediumFormType");

			}

			if (mrequest.getParameter("complexFormType") != null
					&& !"".equals(mrequest.getParameter("complexFormType"))) {
				complexFormType = mrequest.getParameter("complexFormType");

			}
			if (mrequest.getParameter("multipleSelection") != null
					&& !"".equals(mrequest.getParameter("multipleSelection"))) {
				multipleSelection = mrequest.getParameter("multipleSelection");

			}
			String  radioText1 = ""; 
			if (mrequest.getParameter("radioText1") != null
					&& !"".equals(mrequest.getParameter("radioText1"))) {
				radioText1 = mrequest.getParameter("radioText1");

			}
			String  radioDefault1 = ""; 
			if (mrequest.getParameter("radioDefault1") != null
					&& !"".equals(mrequest.getParameter("radioDefault1"))) {
				radioDefault1 = mrequest.getParameter("radioDefault1");

			}
			String  radioText2 = ""; 
			if (mrequest.getParameter("radioText2") != null
					&& !"".equals(mrequest.getParameter("radioText2"))) {
				radioText2 = mrequest.getParameter("radioText2");

			}
			String  radioDefault2 = ""; 
			if (mrequest.getParameter("radioDefault2") != null
					&& !"".equals(mrequest.getParameter("radioDefault2"))) {
				radioDefault2 = mrequest.getParameter("radioDefault2");

			}
			
			String  unitLabel = ""; 
			if (mrequest.getParameter("unitLabel") != null && !"".equals(mrequest.getParameter("unitLabel"))) {
				radioText2 = mrequest.getParameter("unitLabel");

			}
			
			int  maxlength = 0; 
			if (mrequest.getParameter("textMaxLength") != null && !"".equals(mrequest.getParameter("textMaxLength"))) {
				maxlength = Integer.parseInt(mrequest.getParameter("textMaxLength"));

			}
			
			String  datatype = ""; 
			if (mrequest.getParameter("dataType") != null && !"".equals(mrequest.getParameter("dataType"))) {
				datatype = mrequest.getParameter("dataType");

			}
			
			if (mrequest.getParameter("nadRequired") != null && !mrequest.getParameter("nadRequired").equals("")) {
				nadRequired = mrequest.getParameter("nadRequired");
			}else{
				nadRequired = "n";
			}
			if (mrequest.getParameter("noOfFields") != null && !mrequest.getParameter("noOfFields").equals("")) {
				noOfFields = Integer.parseInt(mrequest.getParameter("noOfFields"));
			}
			

			String userHome = getServletContext().getRealPath("");
			String fileSeparator = System.getProperty("file.separator");
			String uploadURL = userHome.substring(0,
					userHome.lastIndexOf(fileSeparator))
					+ fileSeparator
					+ "HMSDocumentFolder"
					+ fileSeparator
					+ "upload" + fileSeparator;

			log.info("upload url is " + uploadURL);

			HMSUtil.createFolderFroDocument(dpartName, uploadURL);
			List fileUploadedList = null;
			/*
			 * int uploadCount =
			 * Integer.parseInt(mrequest.getParameter("uploadCount"));
			 */
			/* box.put("uploadCount", uploadCount); */
			Hashtable files = mrequest.getFiles();

			int i = 1;
			/* for (i = 1; i <= uploadCount; i++) { */
			UploadFile file = (UploadFile) files
					.get(RequestConstants.UPLOAD_FILENAME + i);
			if (file != null && file.getFileName() != null) // && fileSize <= //
															// 2097152 )
			{

				String fileName1 = file.getFileName();

				StringTokenizer strToken = new StringTokenizer(fileName1, ".");

				fileName = strToken.nextToken();
				fileExtension = strToken.nextToken();

				String whiteList = "*." + fileExtension;

				fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
						+ dpartName + fileSeparator, whiteList, fileName1, i);
				box.put("filename", fileName1);
				box.put("fileExtension", fileExtension);
				box.put("uploadURL", uploadURL);
				box.put("fileSeparator", fileSeparator);
			} else {
				box.put("filename", "0");
			}
			/* } */

			generalMap.put("hospitalId", hospitalId);
			box.put("hospitalId", hospitalId);
			generalMap.put("img", img);
			box.put("img", img);
			generalMap.put("valueType", valueType);
			box.put("valueType", valueType);
			box.put("template", template);
			generalMap.put("template", template);
			generalMap.put("userId", userId);
			box.put("userId", userId);
			generalMap.put("code", code);
			box.put("code", code);
			generalMap.put("dpartName", dpartName);
			box.put("dpartName", dpartName);
			generalMap.put("id", id);
			box.put("id", id);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("name", grpName);
			box.put("name", grpName);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);

			if (valueType.equalsIgnoreCase("LOV")) {
				generalMap.put("values", values);
				log.info("values====="+values);
				box.put("values", values);
			if(defaultValues != null){
				generalMap.put("defaultValues", defaultValues);
				box.put("defaultValues", defaultValues);
			}
			
			if(extraText != null){
				generalMap.put("extraText", extraText);
				box.put("extraText", extraText);
			 }
			}
			
			generalMap.put("snoGp", snoGp);
			box.put("snoGp", snoGp);
			generalMap.put("snoPa", snoPa);
			box.put("snoPa", snoPa);
			generalMap.put("parameter", parameter);
			generalMap.put("checkbox", checkbox);
			generalMap.put("extraLov", extraLov);
			generalMap.put("textFont", textFont);
			generalMap.put("textColor", textColor);
			generalMap.put("textSize", textSize);
			generalMap.put("validationValue", validationValue);
			generalMap.put("dateFields", dateFields);
			generalMap.put("grid", grid);
			generalMap.put("simpleFormType", simpleFormType);
			generalMap.put("mediumFormType", mediumFormType);
			generalMap.put("complexFormType", complexFormType);
			generalMap.put("radioText1", radioText1);
			generalMap.put("radioDefault1", radioDefault1);
			generalMap.put("radioText2", radioText2);
			generalMap.put("radioDefault2", radioDefault2);
			generalMap.put("multipleSelection", multipleSelection);
			generalMap.put("nadRequired", nadRequired);
			generalMap.put("noOfFields", noOfFields);
			generalMap.put("unitLabel", unitLabel);
			generalMap.put("datatype", datatype);
			generalMap.put("maxlength", maxlength);
			
			generalMap.put("box", box);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		List groupCodeList = new ArrayList();
		List groupNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			groupCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			groupNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((groupCodeList.size() == 0 || groupCodeList == null)
				&& (groupNameList.size() == 0 || groupNameList == null)) {

			successfullyAdded = generalMasterHandlerService
					.addDepartmentGroupParameter(generalMap);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((groupCodeList.size() != 0 || groupCodeList != null)
				|| (groupNameList.size() != 0) || groupNameList != null) {
			if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() == 0 || groupNameList == null)) {
				message = "Group Code already exists.";
			} else if ((groupNameList.size() != 0 || groupNameList != null)
					&& (groupCodeList.size() == 0 || groupCodeList == null)) {
				message = "Department Name already exists.";
			} else if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() != 0 || groupNameList != null)) {
				message = "Group Code and State exist.";
			}
		}
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			map1 = generalMasterHandlerService.showDepartmentGroupParameter(map1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_GROUP_PARAMETER;
		title = "DepartmentGroup";
		jsp += ".jsp";
		// map.put("pageNo",
		// Integer.parseInt(request.getParameter("pageNoEdit")));
		map1.put("contentJsp", jsp);
		map1.put("title", title);
		map1.put("url", url);
		map1.put("message", message);
		return new ModelAndView("index", "map", map1);

	}
	public ModelAndView showDeparmentGroupValue(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		map = generalMasterHandlerService.showDeparmentGroupValue(box);
		return new ModelAndView("responseForDeptGroup", "map", map);
	}
	
	public ModelAndView editDepartmentGroupParameter(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		HttpSession session = request.getSession();
	
		int id = 0;

		Integer userId = (Integer) session.getAttribute("userId");

		String valueType = "";
		String img = "";
		String dpartName = "";
		String grpName = "";
		String changedBy = "";
		String tempLate = "";
		String parameter = "";
		String snoPa = "";
		String snoGp = "";
		String dateFields = "";
		String grid = "";
		String simpleFormType = "";
		String mediumFormType = "";
		String complexFormType = "";
		int hospitalId =0;
		
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Box box = HMSUtil.getBox(mrequest);
		try {

			if (mrequest.getParameter(COMMON_ID) != null
					&& !(mrequest.getParameter(COMMON_ID).equals(""))) {
				id = Integer.parseInt(mrequest.getParameter(COMMON_ID));
			}
			if (mrequest.getParameter("parameter") != null
					&& !(mrequest.getParameter("parameter").equals(""))) {
				parameter = mrequest.getParameter("parameter");
			}
			log.info("groupparameter=in controller========"+parameter);
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}

			if (mrequest.getParameter(CODE) != null) {
				code = mrequest.getParameter(CODE);
				log.info("CODE" + request.getParameter(CODE));
			}

			if (mrequest.getParameter(CODE) != null) {
				dpartName = mrequest.getParameter(CODE);
				log.info("dpartName" + request.getParameter(CODE));
			}
			String extraLov = "";
			if (mrequest.getParameter("extraLov") != null
					&& !"".equals(mrequest.getParameter("extraLov"))) {
				extraLov = mrequest.getParameter("extraLov");

			}

			if (mrequest.getParameter(VALUE_TYPE) != null) {
				valueType = mrequest.getParameter(VALUE_TYPE);
			}
			String values[] = null;
			String defaultValues[]= null;
			String extraText[]= null;
			if (valueType.equalsIgnoreCase("LOV") ||  extraLov.equalsIgnoreCase("l")) {
				if (mrequest.getParameterValues("values") != null) {
					values = mrequest.getParameterValues("values");

					
					if (mrequest.getParameterValues("defaultValues") != null) {
						defaultValues = mrequest.getParameterValues("defaultValues");
					}
					
					if (mrequest.getParameterValues("extraText") != null) {
						extraText = mrequest.getParameterValues("extraText");
					}
				}
			}
			
			
			if (mrequest.getParameter(IMG_REQ) != null) {
				img = mrequest.getParameter(IMG_REQ);
				log.info("IMG_REQ" + request.getParameter(IMG_REQ));
			}
			if (mrequest.getParameter("grpName") != null) {
				grpName = mrequest.getParameter("grpName");
				log.info("grpName" + request.getParameter("grpName"));
			}

			if (mrequest.getParameter(CHANGED_BY) != null
					&& !(mrequest.getParameter(CHANGED_BY).equals(""))) {
				changedBy = mrequest.getParameter(CHANGED_BY);
			}
			if (mrequest.getParameter(CHANGED_TIME) != null
					&& !(mrequest.getParameter(CHANGED_TIME).equals(""))) {
				changedTime = mrequest.getParameter(CHANGED_TIME);
			}
			if (mrequest.getParameter("tempLate") != null
					&& !(mrequest.getParameter("tempLate").equals(""))) {
				tempLate = mrequest.getParameter("tempLate");
			}
			if (mrequest.getParameter("snoGp") != null
					&& !(mrequest.getParameter("snoGp").equals(""))) {
				snoGp = mrequest.getParameter("snoGp");
			}
			log.info("grpsequencein====in controleerl======"+snoGp);
			if (mrequest.getParameter("snoPa") != null
					&& !(mrequest.getParameter("snoPa").equals(""))) {
				snoPa = mrequest.getParameter("snoPa");
			}
			log.info("para=sequencein controller=========="+mrequest.getParameter("snoPa"));
			String checkbox = "";
			if (mrequest.getParameter("checkbox") != null
					&& !"".equals(mrequest.getParameter("checkbox"))) {
				checkbox = mrequest.getParameter("checkbox");

			}
			if (mrequest.getParameter("dateFields") != null
					&& !"".equals(mrequest.getParameter("dateFields"))) {
				dateFields = mrequest.getParameter("dateFields");
			}
			if (mrequest.getParameter("grid") != null
					&& !"".equals(mrequest.getParameter("grid"))) {
				grid = mrequest.getParameter("grid");

			}

			if (mrequest.getParameter("simpleFormType") != null
					&& !"".equals(mrequest.getParameter("simpleFormType"))) {
				simpleFormType = mrequest.getParameter("simpleFormType");

			}

			if (mrequest.getParameter("mediumFormType") != null
					&& !"".equals(mrequest.getParameter("mediumFormType"))) {
				mediumFormType = mrequest.getParameter("mediumFormType");

			}

			if (mrequest.getParameter("complexFormType") != null
					&& !"".equals(mrequest.getParameter("complexFormType"))) {
				complexFormType = mrequest.getParameter("complexFormType");

			}
			String  radioText1 = ""; 
			if (mrequest.getParameter("radioText1") != null
					&& !"".equals(mrequest.getParameter("radioText1"))) {
				radioText1 = mrequest.getParameter("radioText1");

			}
			String  radioDefault1 = ""; 
			if (mrequest.getParameter("radioDefault1") != null
					&& !"".equals(mrequest.getParameter("radioDefault1"))) {
				radioDefault1 = mrequest.getParameter("radioDefault1");

			}
			String  radioText2 = ""; 
			if (mrequest.getParameter("radioText2") != null
					&& !"".equals(mrequest.getParameter("radioText2"))) {
				radioText2 = mrequest.getParameter("radioText2");

			}
			String  radioDefault2 = ""; 
			if (mrequest.getParameter("radioDefault2") != null
					&& !"".equals(mrequest.getParameter("radioDefault2"))) {
				radioDefault2 = mrequest.getParameter("radioDefault2");

			}
			String  unitLabel = ""; 
			if (mrequest.getParameter("unitLabel") != null && !"".equals(mrequest.getParameter("unitLabel"))) {
				unitLabel = mrequest.getParameter("unitLabel");

			}
			
			int  maxlength = 0; 
			if (mrequest.getParameter("textMaxLength") != null && !"".equals(mrequest.getParameter("textMaxLength"))) {
				maxlength = Integer.parseInt(mrequest.getParameter("textMaxLength"));

			}
			
			String  datatype = ""; 
			if (mrequest.getParameter("dataType") != null && !"".equals(mrequest.getParameter("dataType"))) {
				datatype = mrequest.getParameter("dataType");
			}
			
			
			
			String textFont = "";
			if (mrequest.getParameter("textFont") != null
					&& !"".equals(mrequest.getParameter("textFont"))) {
				textFont = mrequest.getParameter("textFont");

			}
			String textColor = "";
			if (mrequest.getParameter("textColor") != null
					&& !"".equals(mrequest.getParameter("textColor"))) {
				textColor = mrequest.getParameter("textColor");

			}
			
			String textSize = "";
			if (mrequest.getParameter("textSize") != null
					&& !"".equals(mrequest.getParameter("textSize"))) {
				textSize = mrequest.getParameter("textSize");

			}
			
			String validationValue = "";
			if (mrequest.getParameter("validationValue") != null
			&& !"".equals(mrequest.getParameter("validationValue"))) {
				validationValue = mrequest.getParameter("validationValue");

			}
			
			String nadRequired = "";
			if (mrequest.getParameter("nadRequired") != null && !mrequest.getParameter("nadRequired").equals("")) {
				nadRequired = mrequest.getParameter("nadRequired");
			}else{
				nadRequired = "n";
			}
			String multipleSelection = "";
			if (mrequest.getParameter("multipleSelection") != null && !"".equals(mrequest.getParameter("multipleSelection"))) {
				multipleSelection = mrequest.getParameter("multipleSelection");

			}

			int noOfFields=0;
			if (mrequest.getParameter("noOfFields") != null && !mrequest.getParameter("noOfFields").equals("")) {
				noOfFields = Integer.parseInt(mrequest.getParameter("noOfFields"));
			}
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			if (valueType.equalsIgnoreCase("LOV")) {
				box.put("values", values);
			if(defaultValues != null){
				box.put("defaultValues", defaultValues);
			 }
			if(extraText != null){
				box.put("extraText", extraText);
			 }
			
			}
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("id", id);
			generalMap.put("dpartName", dpartName);
			generalMap.put("name", grpName);
			generalMap.put("userId", userId);
			generalMap.put("img", img);
			generalMap.put("valueType", valueType);
			generalMap.put("changedBy", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("parameter", parameter);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("tempLate", tempLate);
			generalMap.put("tempLate", tempLate);
			generalMap.put("extraLov", extraLov);
			generalMap.put("textFont", textFont);
			generalMap.put("textColor", textColor);
			generalMap.put("textSize", textSize);
			generalMap.put("validationValue", validationValue);
			
			
			generalMap.put("snoGp", snoGp);
			generalMap.put("snoPa", snoPa);
			generalMap.put("nadRequired", nadRequired);
			generalMap.put("dateFields", dateFields);
			generalMap.put("grid", grid);
			generalMap.put("simpleFormType", simpleFormType);
			generalMap.put("mediumFormType", mediumFormType);
			generalMap.put("complexFormType", complexFormType);
			
			generalMap.put("radioText1", radioText1);
			generalMap.put("radioDefault1", radioDefault1);
			generalMap.put("radioText2", radioText2);
			generalMap.put("radioDefault2", radioDefault2);
			
			generalMap.put("maxlength", maxlength);
			generalMap.put("unitLabel", unitLabel);
			generalMap.put("datatype", datatype);
			
			generalMap.put("noOfFields", noOfFields);
			generalMap.put("multipleSelection", multipleSelection);
			generalMap.put("checkbox", checkbox);

			generalMap.put("flag", true);

			boolean dataUpdated = false;
			try {
				dataUpdated = generalMasterHandlerService
						.editDepartmentGroupParameter(generalMap,box);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";

			} else {
				message = "Data Cant be updated !!";
			}

			map = generalMasterHandlerService.showDepartmentGroupParameter(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DEPARTMENT_GROUP_PARAMETER;
		title = "DepartmentGroup";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDepartmentGroupParameter(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int id = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";

		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;

		Integer userId = (Integer) session.getAttribute("userId");

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (mrequest.getParameter(COMMON_ID) != null) {
			id = Integer.parseInt(mrequest.getParameter(COMMON_ID));
			log.info("id" + mrequest.getParameter(COMMON_ID));
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
		generalMap.put("userId", userId);
		generalMap.put("id", id);
		generalMap.put("box", box);

		boolean dataDeleted = false;
		dataDeleted = generalMasterHandlerService
				.deleteDepartmentGroupParameter(id, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showGroupParaMasterJSP";

		Map<String, Object> details = new HashMap<String, Object>();

		try {
			map = generalMasterHandlerService.showDepartmentGroupParameter(details);

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = DEPARTMENT_GROUP_PARAMETER;
		title = "DepartmentGroup";

		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		// map.put("mapForSpGroupParameterT", mapForSpGroupParameterT);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchDepartmentGroupParameter(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dipartFieldsMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;

		String searchField = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			if (request.getParameter(SEARCH_FIELD) != null	&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map = generalMasterHandlerService.searchDepartmentGroupParameter(searchField);

		jsp = DEPARTMENT_GROUP_PARAMETER + ".jsp";
		title = "DepartmentGroup";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// -----------------------------------

	// ---------------------------------------
	// SpecialtyTemplate ----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showSpecialtyTemplateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showSpecialtyTemplate();
		String jsp = "specialtyTemplate";
		jsp += ".jsp";
		title = "SpecialtyTemplate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSpecialtyTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasSpecialtyTemplate masSpecialtyTemplate = new MasSpecialtyTemplate();
		String changedBy = " ";

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		HttpSession session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = 0;
		String templateType = "";
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
			
			if (request.getParameter("templateType") != null) {
				templateType = request.getParameter("templateType");
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
			generalMap.put("templateType", templateType);

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

		List specialtyTemplateCodeList = new ArrayList();
		List specialtyTemplateNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			specialtyTemplateCodeList = (List) listMap
					.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			specialtyTemplateNameList = (List) listMap
					.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((specialtyTemplateCodeList.size() == 0 || specialtyTemplateCodeList == null)
				&& (specialtyTemplateNameList.size() == 0 || specialtyTemplateNameList == null)) {
			masSpecialtyTemplate.setTemplateCode(code);
			masSpecialtyTemplate.setTemplateName(name);

			masSpecialtyTemplate.setStatus("Y");
			Users users = new Users();
			users.setId(userId);
			
			if(!templateType.equals("")){
				masSpecialtyTemplate.setTemplateType(templateType);
			}

			masSpecialtyTemplate.setLastChgBy(users);
			masSpecialtyTemplate.setLastChgDate(currentDate);
			masSpecialtyTemplate.setLastChgTime(currentTime);
			Map<String, Object> specialtyTemplateMap = new HashMap<String, Object>();


			specialtyTemplateMap.put("masSpecialtyTemplate",
					masSpecialtyTemplate);
			specialtyTemplateMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addSpecialtyTemplate(specialtyTemplateMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((specialtyTemplateCodeList.size() != 0 || specialtyTemplateCodeList != null)
				|| (specialtyTemplateNameList.size() != 0)
				|| specialtyTemplateNameList != null) {
			if ((specialtyTemplateCodeList.size() != 0 || specialtyTemplateCodeList != null)
					&& (specialtyTemplateNameList.size() == 0 || specialtyTemplateNameList == null)) {
				message = "Specialty Template  Code already exists.";
			} else if ((specialtyTemplateNameList.size() != 0 || specialtyTemplateNameList != null)
					&& (specialtyTemplateCodeList.size() == 0 || specialtyTemplateCodeList == null)) {
				message = "Specialty Template  Name already exists.";
			} else if ((specialtyTemplateCodeList.size() != 0 || specialtyTemplateCodeList != null)
					&& (specialtyTemplateNameList.size() != 0 || specialtyTemplateNameList != null)) {
				message = "Specialty Template  Code and Specialty Template Name  exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showSpecialtyTemplate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "specialtyTemplate";
		title = "Add Specialty Template ";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editSpecialtyTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		String specialtyTemplateCode = "";
		String name = "";
		int specialtyTemplateId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		String templateType = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				specialtyTemplateId = Integer.parseInt(request
						.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				specialtyTemplateCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				name = request.getParameter(SEARCH_NAME);
			}
			
			if (request.getParameter("templateType") != null && !(request.getParameter("templateType").equals(""))) {
				templateType = request.getParameter("templateType");
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

			generalMap.put("id", specialtyTemplateId);
			generalMap.put("specialtyTemplateCode", specialtyTemplateCode);
			generalMap.put("name", name);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("templateType", templateType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService
					.editSpecialtyTemplate(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showSpecialtyTemplate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "specialtyTemplate";
		title = "Edit SpecialtyTemplate";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchSpecialtyTemplate(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String specialtyTemplateCode = null;
		String specialtyTemplateName = null;
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
			specialtyTemplateCode = searchField;
			specialtyTemplateName = null;

		} else {
			specialtyTemplateCode = null;
			specialtyTemplateName = searchField;
		}
		map = generalMasterHandlerService.searchSpecialtyTemplate(
				specialtyTemplateCode, specialtyTemplateName);

		jsp = "specialtyTemplate";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("specialtyTemplateCode", specialtyTemplateCode);
		map.put("specialtyTemplateName", specialtyTemplateName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteSpecialtyTemplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int specialtyTemplateId = 0;
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
			specialtyTemplateId = Integer.parseInt(request
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
		dataDeleted = generalMasterHandlerService.deleteSpecialtyTemplate(
				specialtyTemplateId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showSpecialtyTemplateJsp";

		try {
			map = generalMasterHandlerService.showSpecialtyTemplate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "specialtyTemplate";
		title = "delete SpecialtyTemplate";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// -------------------------- Report Method By Mansi on 31 July 2013

	public ModelAndView generateReportForGeneralMasters(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		int hospitalId = 0;
		String hospitalName = "";
		String qry = "";
		String searchField = "";
	
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("hospitalId", hospitalId);
			mapResponse = generalMasterHandlerService.getHospitalName(mapForDs);
		}
		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List<MasHospital>) mapResponse.get("masHospitaList");
			if(masHospitaList.size()>0){
			hospitalName = masHospitaList.get(0).getHospitalName();
			}
		}
		String colCode = "";
		if (request.getParameter("colCode") != null
				&& !(request.getParameter("colCode").equals(""))) {
			colCode = request.getParameter("colCode");
		}
		String colName = "";
		if (request.getParameter("colName") != null
				&& !(request.getParameter("colName").equals(""))) {
			colName = request.getParameter("colName");
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
		log.info("searchRadio---" + searchRadio+" searchField--"+searchField);
		String hosStr="";
		if(hospitalId>0){
			hosStr=hosStr+" hos.hospital_id = "+hospitalId;
		}
		if (searchRadio == 1) {

			if (!searchField.equals("")) {
				qry = "where upper(" + colCode + ") like upper('%"
						+ searchField + "%')"+hosStr;
			} else {
				qry = "where "+hosStr;
			}
		} else if (searchRadio == 2) {
			if (!searchField.equals("")) {
				qry = "where upper(" + colName + ") like upper('%"
						+ searchField + "%')"+hosStr;
			} else {
				qry = "where "+hosStr;
			}
		} else {
			qry = "where "+hosStr;
		}
		
		//qry=" where mas_ward.ward_code='1017011'";

		
		String jasper = null;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("qry", qry);
		parameters.put("hospitalName", hospitalName);
		//parameters.put("hospitalId", hospitalId);
		
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/reports/"));

		Map<String, Object> connectionMap = generalMasterHandlerService
				.getConnection();

		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView generateReportForCatgory(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		int hospitalId = 0;
		String hospitalName = "";
		String qry = "";
		String searchField = "";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("hospitalId", hospitalId);
			mapResponse = generalMasterHandlerService.getHospitalName(mapForDs);
		}
		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
		}

		String colCode = "";
		if (request.getParameter("colCode") != null
				&& !(request.getParameter("colCode").equals(""))) {
			colCode = request.getParameter("colCode");
		}
		String colName = "";
		if (request.getParameter("colName") != null
				&& !(request.getParameter("colName").equals(""))) {
			colName = request.getParameter("colName");
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
		log.info("searchRadio---" + searchRadio);
		if (searchRadio == 1) {

			if (!searchField.equals("")) {
				qry = " and upper(" + colCode + ") like upper('%" + searchField
						+ "%')";
			} else {
				qry = "";
			}
		} else if (searchRadio == 2) {
			if (!searchField.equals("")) {
				qry = " and upper(" + colName + ") like upper('%" + searchField
						+ "%')";
			} else {
				qry = "";
			}
		} else {
			qry = "";
		}

		String jasper = null;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("qry", qry);
		parameters.put("hospitalName", hospitalName);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/reports/"));

		Map<String, Object> connectionMap = generalMasterHandlerService
				.getConnection();

		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());

		return null;
	}

	// ---------------- Specialty ----------------------

	public ModelAndView showSpecialtyJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map map = new HashMap();
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		String deptName = "";
		deptName = generalMasterHandlerService.getDepartmentNameFromId(deptId);

		map = generalMasterHandlerService.showSpecialtyJsp();
		map.put("deptName", deptName);
		String jsp = SPECIALTY_JSP;
		jsp += ".jsp";
		title = "Title";
		map.put("contentJsp", jsp);

		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showGroupAndParameterValues(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		Map generalMap = new HashMap();
		
		HttpSession session = request.getSession();

		String template = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		log.info("deptid" + deptId);

		if (request.getParameter("tempLate") != null
				&& !(request.getParameter("tempLate").equals(""))) {
			template = request.getParameter("tempLate");
		}

		generalMap.put("template", template);
		generalMap.put("deptId", deptId);
		map = generalMasterHandlerService
				.showGroupAndParameterValues(generalMap);
		
		String jsp = "groupParameterValue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showPopUpForValues(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String values = "";
		MasSpecialityDeptGroupValue deptGroupValue = null;
		HttpSession session = request.getSession();
		int deptId = 0;
		int departmentId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("departmentId") != null
				&& !"".equals(request.getParameter("departmentId").toString())) {
			departmentId = Integer.parseInt(request
					.getParameter("departmentId"));
		}
		dataMap.put("departmentId", departmentId);
		map = generalMasterHandlerService.showPopUpForValues(dataMap);
		List<MasSpecialityDeptGroupValue> deptGroupValues = (List) map
				.get("masValue");
		if (deptGroupValues.size() != 0) {
			deptGroupValue = (MasSpecialityDeptGroupValue) deptGroupValues
					.get(0);
			map.put("valueName", deptGroupValue.getValue());

		}

		jsp = "valueForSpecial";
		jsp += ".jsp";
		title = "valueForSpecial";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("valueForSpecial", "map", map);
	}

	// ----------------- -------- -------------------------------------

	public ModelAndView saveSpeciality(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		generalMap.put("box", box);
		int userId = (Integer) session.getAttribute("userId");
		int hsId = (Integer) session.getAttribute("hospitalId");
		generalMap.put("userId", userId);
		generalMap.put("hsId", hsId);

		successfullyAdded = generalMasterHandlerService
				.saveSpeciality(generalMap);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = "messagejsp";
		map.put("message", message);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------------
	// Questions----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showQuestionsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showQuestions();
		String jsp = "questions";
		jsp += ".jsp";
		title = "Questions";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addQuestions(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasQuestions masQuestions = new MasQuestions();
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

		List questionnoList = new ArrayList();
		List questionList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			questionnoList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			questionList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((questionnoList.size() == 0 || questionnoList == null)
				&& (questionList.size() == 0 || questionList == null)) {
			masQuestions.setQuestionno(code);
			masQuestions.setQuestion(name);

			masQuestions.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			masQuestions.setLastChgBy(users);
			masQuestions.setLastChgDate(currentDate);
			masQuestions.setLastChgTime(currentTime);
			Map<String, Object> questionsMap = new HashMap<String, Object>();

			log.info("masQuestions" + masQuestions);

			questionsMap.put("masQuestions", masQuestions);
			questionsMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addQuestions(questionsMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((questionnoList.size() != 0 || questionnoList != null)
				|| (questionList.size() != 0) || questionList != null) {
			if ((questionnoList.size() != 0 || questionnoList != null)
					&& (questionList.size() == 0 || questionList == null)) {
				message = "Questions Code already exists.";
			} else if ((questionList.size() != 0 || questionList != null)
					&& (questionnoList.size() == 0 || questionnoList == null)) {
				message = "Questions Name already exists.";
			} else if ((questionnoList.size() != 0 || questionnoList != null)
					&& (questionList.size() != 0 || questionList != null)) {
				message = "Questions Code and Questions exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showQuestions();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "questions";
		title = "Add Questions";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editQuestions(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		String questionno = "";
		String name = "";
		int questionsId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				questionsId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				questionno = request.getParameter(CODE);
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

			generalMap.put("id", questionsId);
			generalMap.put("questionno", questionno);
			generalMap.put("name", name);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService.editQuestions(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showQuestions();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "questions";
		title = "Edit Questions";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchQuestions(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String questionno = null;
		String question = null;
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
			questionno = searchField;
			question = null;

		} else {
			questionno = null;
			question = searchField;
		}
		map = generalMasterHandlerService.searchQuestions(questionno, question);

		jsp = "questions";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("questionno", questionno);
		map.put("question", question);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteQuestions(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int questionsId = 0;
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
			questionsId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteQuestions(questionsId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showQuestionsJsp";

		try {
			map = generalMasterHandlerService.showQuestions();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "questions";
		title = "delete Questions";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// ------------------------------------------Answers
	// ----------------------------------

	public ModelAndView searchAnswers(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String answersName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			answersName = request.getParameter(SEARCH_NAME);
		}
		map = generalMasterHandlerService.searchAnswers(answersName);
		jsp = "answers";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("answersName", answersName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showAnswersJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = generalMasterHandlerService.showAnswersJsp();
		String jsp = "answers";
		jsp += ".jsp";
		title = "Answers";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAnswers(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasAnswers masAnswers = new MasAnswers();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

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
		List answersNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			answersNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((answersNameList.size() == 0 || answersNameList == null)
				&& (answersNameList.size() == 0 || answersNameList == null)) {
			masAnswers.setAnswersName(name);
			masAnswers.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			masAnswers.setLastChgBy(users);
			masAnswers.setLastChgDate(currentDate);
			masAnswers.setLastChgTime(currentTime);
			successfullyAdded = generalMasterHandlerService
					.addAnswers(masAnswers);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((answersNameList.size() != 0) || answersNameList != null) {
			if ((answersNameList.size() != 0 || answersNameList != null)) {
				message = "Answers Name already exists.";
			}
		}
		try {
			map = generalMasterHandlerService.showAnswersJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "answers";
		title = "Add Answers";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAnswers(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		MasAnswers masAnswers = new MasAnswers();
		session = request.getSession();
		String answersName = "";
		int answersId = 0;
		String local = "";
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			answersId = Integer.parseInt(request.getParameter(COMMON_ID));
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			answersName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", answersId);
		generalMap.put("name", answersName);
		generalMap.put("local", local);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOccupationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingOccupationNameList.size() == 0) {
			dataUpdated = generalMasterHandlerService
					.editAnswersToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingOccupationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showAnswersJsp";

		try {
			map = generalMasterHandlerService.showAnswersJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "answers";
		title = "update Answers";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAnswers(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int answersId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		Map<String, Object> generalMap = new HashMap<String, Object>();
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			answersId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteAnswers(answersId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showAnswersJsp";

		try {
			map = generalMasterHandlerService.showAnswersJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "answers";
		title = "delete Answers";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------ QuestionAnswers

	public ModelAndView showQuestionAnswersJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = generalMasterHandlerService.showQuestionAnswersJsp();
		String jsp = "questionAnswers";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addQuestionAnswers(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		map = generalMasterHandlerService.addQuestionAnswers(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "questionAnswers";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateQuestionAnswers(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		map = generalMasterHandlerService.updateQuestionAnswers(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "questionAnswers";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteQuestionAnswers(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		boolean dataDeleted = false;

		dataDeleted = generalMasterHandlerService.deleteQuestionAnswers(box);
		if (dataDeleted == true) {
			if (box.getString("flag").equals("InActivate"))
				message = "Record is InActivated successfully !!";
			else if (box.getString("flag").equals("Activate"))
				message = "Record is Activated successfully !!";
		} else {
			message = "Some Problem occured!";
		}
		try {
			map = generalMasterHandlerService.showQuestionAnswersJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "questionAnswers";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchQuestionAnswers(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = generalMasterHandlerService.searchQuestionAnswers(box);
		jsp = "questionAnswers";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------------
	// EmpDept----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showEmpDeptJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showEmpDept();
		String jsp = "empDept";
		jsp += ".jsp";
		title = "EmpDept";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmpDept(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasEmployeeDepartment masEmpDept = new MasEmployeeDepartment();
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

		List empDeptCodeList = new ArrayList();
		List empDeptNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			empDeptCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			empDeptNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((empDeptCodeList.size() == 0 || empDeptCodeList == null)
				&& (empDeptNameList.size() == 0 || empDeptNameList == null)) {
			masEmpDept.setEmpDeptCode(code);
			masEmpDept.setEmpDeptName(name);

			masEmpDept.setStatus("Y");
			Users users = new Users();
			users.setId(userId);

			masEmpDept.setLastChgBy(users);
			masEmpDept.setLastChgDate(currentDate);
			masEmpDept.setLastChgTime(currentTime);
			Map<String, Object> empDeptMap = new HashMap<String, Object>();

			log.info("masEmpDept" + masEmpDept);

			empDeptMap.put("masEmpDept", masEmpDept);
			empDeptMap.put("hospitalId", hospitalId);
			successfullyAdded = generalMasterHandlerService
					.addEmpDept(empDeptMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((empDeptCodeList.size() != 0 || empDeptCodeList != null)
				|| (empDeptNameList.size() != 0) || empDeptNameList != null) {
			if ((empDeptCodeList.size() != 0 || empDeptCodeList != null)
					&& (empDeptNameList.size() == 0 || empDeptNameList == null)) {
				message = "EmpDept Code already exists.";
			} else if ((empDeptNameList.size() != 0 || empDeptNameList != null)
					&& (empDeptCodeList.size() == 0 || empDeptCodeList == null)) {
				message = "EmpDept Name already exists.";
			} else if ((empDeptCodeList.size() != 0 || empDeptCodeList != null)
					&& (empDeptNameList.size() != 0 || empDeptNameList != null)) {
				message = "EmpDept Code and EmpDept exist.";
			}
		}

		try {
			map = generalMasterHandlerService.showEmpDept();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "empDept";
		title = "Add EmpDept";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editEmpDept(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession();
		String empDeptCode = "";
		String name = "";
		int empDeptId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		try {

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				empDeptId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				empDeptCode = request.getParameter(CODE);
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

			generalMap.put("id", empDeptId);
			generalMap.put("empDeptCode", empDeptCode);
			generalMap.put("name", name);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = generalMasterHandlerService.editEmpDept(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";

		} else {
			message = "Data Cant be updated !!";
		}

		try {
			map = generalMasterHandlerService.showEmpDept();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "empDept";
		title = "Edit EmpDept";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchEmpDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String empDeptCode = null;
		String empDeptName = null;
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
			empDeptCode = searchField;
			empDeptName = null;

		} else {
			empDeptCode = null;
			empDeptName = searchField;
		}
		map = generalMasterHandlerService.searchEmpDept(empDeptCode,
				empDeptName);

		jsp = "empDept";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("empDeptCode", empDeptCode);
		map.put("empDeptName", empDeptName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteEmpDept(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		int empDeptId = 0;
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
			empDeptId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteEmpDept(empDeptId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showEmpDeptJsp";

		try {
			map = generalMasterHandlerService.showEmpDept();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "empDept";
		title = "delete EmpDept";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showInstWiseEmpDeptJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int hospitalId = 0;
		Map<String, Object> map = new HashMap<String, Object>();

		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID)
						.equals(""))) {
			hospitalId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
		}
		Map<String,Object> dataMap = new HashMap<String,Object>();
		Users users=null;
		int userType=0;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			userType=users.getUserType();
			dataMap.put("userId", users.getId());
		}
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userType", userType);
		map = generalMasterHandlerService.showInstWiseEmpDeptJsp(dataMap);
		List<MasEmployeeDepartment> employeeDepartmentList = new ArrayList<MasEmployeeDepartment>();

		jsp = "instWiseEmpDept";
		jsp += ".jsp";
		title = "Inst. Wise Emp. Dept.";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("userType", userType);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveInstWiseEmpDept(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		int userId = (Integer) session.getAttribute(USER_ID);
		int instId = 0;
		String flag = "";

		if (request.getParameter("instId") != null
				&& !request.getParameter("instId").equals("0")) {
			instId = Integer.parseInt(request.getParameter("instId"));
		}

		if (request.getParameter("flag") != null
				&& !request.getParameter("flag").equals("0")) {
			flag = request.getParameter("flag");
		}
		int hrInsitEmpDepId = 0;
		if (request.getParameter("hrInsitEmpDepId") != null
				&& !request.getParameter("hrInsitEmpDepId").equals("")) {
			hrInsitEmpDepId = Integer.parseInt(request
					.getParameter("hrInsitEmpDepId"));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String[] house = {};
		if (request.getParameter("tempId") != null) {
			house = (String[]) request.getParameterValues("tempId");
		}

		String houseStr = "";
		if (house.length != 0) {
			houseStr = house[0];
		}
		for (int i = 1; i < house.length; i++) {
			houseStr = houseStr + "," + house[i];
		}
		log.info(instId + "instIdinstId");
		detailsMap.put("hrInsitEmpDepId", hrInsitEmpDepId);
		detailsMap.put("instId", instId);
		detailsMap.put("userId", userId);
		detailsMap.put("flag", flag);
		detailsMap.put("houseStr", houseStr);

		map = generalMasterHandlerService.saveInstWiseEmpDept(detailsMap);
		Boolean saved = (Boolean) map.get("saved");
		String message = "";
		String jsp = "";
		if (saved) {
			if (flag.equalsIgnoreCase("s")) {
				message = "Saved Successfully.";
			} else {
				message = "Updated Successfully.";
			}

		} else {
			message = "Some Problem Occured.";
		}
		jsp = "messageInstWiseEmpDept";
		map.put("message", message);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView fillHospital(HttpServletRequest request,
			HttpServletResponse response) {
		int Val = Integer.parseInt(request.getParameter("Val"));
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		map = generalMasterHandlerService.fillHospital(Val,
				detailsMap);
		jsp = "responseHospital";
		title = "Hospital";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	// ///-------------------------------- Employee SC Mapping

	public ModelAndView showEmpSCMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		int hospitalId = 0;
		Map<String, Object> map = new HashMap<String, Object>();

		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID)
						.equals(""))) {
			hospitalId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
		}

		map = generalMasterHandlerService.showEmpSCMappingJsp(hospitalId);
		//List<EmpScMapping> empScMappingList = new ArrayList<EmpScMapping>();

		jsp = "empSCMapping";
		jsp += ".jsp";
		title = "Emp. SC. Mapping";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveEmpSCMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		session = request.getSession(true);
		int userId = (Integer) session.getAttribute(USER_ID);
		int empId = 0;
		int hospitalId = 0;
		int seviceCenterrId=0,empcategoryId=0;
		String flag = "";
		String tempId[]=null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		if (session.getAttribute("hospitalId") != null && !(session.getAttribute("hospitalId").equals(""))) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		/*if (request.getParameter("empId") != null
				&& !request.getParameter("empId").equals("0")) {
			empId = Integer.parseInt(request.getParameter("empId"));
		}

		if (request.getParameter("flag") != null
				&& !request.getParameter("flag").equals("0")) {
			flag = request.getParameter("flag");
		}
		int scId = 0;
		if (request.getParameter("scId") != null
				&& !request.getParameter("scId").equals("")) {
			scId = Integer.parseInt(request
					.getParameter("scId"));
		}
		

		String[] house = {};
		if (request.getParameter("tempId") != null) {
			house = (String[]) request.getParameterValues("tempId");
		}

		String houseStr = "";
		if (house.length != 0) {
			houseStr = house[0];
		}
		for (int i = 1; i < house.length; i++) {
			houseStr = houseStr + "," + house[i];
		}*/
	
		//List<Integer> serviceCenterList = new ArrayList<Integer>();
		List<Integer> employeeList = new ArrayList<Integer>();
		
		//EmpScMapping empScMapping = new EmpScMapping();
	 		if (request.getParameterValues("tempId")!= null	&& !request.getParameterValues("tempId").equals("")) {
		 		tempId =request.getParameterValues("tempId");
		 	
	 		for(int k=0;k<tempId.length;k++){
				 	/*MasDepartment masDepartment = new MasDepartment();
				 	masDepartment.setId(Integer.parseInt(tempId[k]));
				 	empScMapping.setDepartment(masDepartment);*/
	 			employeeList.add(Integer.parseInt(tempId[k]));
	 		
			 		/*if (request.getParameter("empId") != null&& !request.getParameter("empId").equals("0")) {
						empId = Integer.parseInt(request.getParameter("empId"));
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(empId);
						empScMapping.setEmployee(masEmployee);
						detailsMap.put("empId", empId);
					}*/
			 		
			 		/*if (request.getParameter("seviceCenterrId") != null&& !request.getParameter("seviceCenterrId").equals("0")) {
			 			seviceCenterrId = Integer.parseInt(request.getParameter("seviceCenterrId"));
						/*MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(empId);
						empScMapping.setEmployee(masEmployee);*/
				/*		detailsMap.put("seviceCenterrId", seviceCenterrId);
					}*/ //changed by govind 13-12-2016
			 		
				/*empScMapping.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
				empScMapping.setLastChgTime(time);
		 	
				Users users = new Users();
				users.setId(userId);
				empScMapping.setLastChgBy(users);*/
	 		}
	 	}
	 		//added by govind 13-12-2016
	 		if (request.getParameter("seviceCenterrId") != null&& !request.getParameter("seviceCenterrId").equals("0")) {
	 			seviceCenterrId = Integer.parseInt(request.getParameter("seviceCenterrId"));
				/*MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empId);
				empScMapping.setEmployee(masEmployee);*/
				detailsMap.put("seviceCenterrId", seviceCenterrId);
			}	
	 		if (request.getParameter("empcategoryId") != null&& !request.getParameter("empcategoryId").equals("0")) {
	 			empcategoryId = Integer.parseInt(request.getParameter("empcategoryId"));
				detailsMap.put("empcategoryId", empcategoryId);
			}
	 		
	 		//added by govind 13-12-2016 end
	 		
	 		
	 		//detailsMap.put("empScMapping", empScMapping);
	 		detailsMap.put("hospitalId", hospitalId);
	 		detailsMap.put("userId", userId);
	 		//detailsMap.put("serviceCenterList", serviceCenterList);
	 		detailsMap.put("employeeList", employeeList);
		map = generalMasterHandlerService.saveEmpSCMapping(detailsMap);
		Boolean saved = (Boolean) map.get("saved");
		String message = "";
		String jsp = "";
		if (saved) {
			if (flag.equalsIgnoreCase("s")) {
				message = "Saved Successfully.";
			} else {
				message = "Updated Successfully.";
			}

		} else {
			message = "Some Problem Occured.";
		}
		jsp = "messageEmpSCMapping";
		map.put("message", message);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

/*	public ModelAndView fillEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		int Val = Integer.parseInt(request.getParameter("Val"));
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int hospitalId = 0;
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID)
						.equals(""))) {
			hospitalId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("hospitalId", hospitalId);
		map = generalMasterHandlerService.fillEmployee(Val,detailsMap);
		jsp = "responseEmployee";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}*/
	
	public ModelAndView fillEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		int Val=0;
		if(request.getParameter("Val") !=null && request.getParameter("Val")!="0")
		 Val = Integer.parseInt(request.getParameter("Val"));
		int empcategoryId=Integer.parseInt(request.getParameter("empcategoryId"));
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int hospitalId = 0;
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID)
						.equals(""))) {
			hospitalId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		detailsMap.put("empcategoryId", empcategoryId);
		detailsMap.put("hospitalId", hospitalId);
		map = generalMasterHandlerService.fillEmployee(Val,detailsMap);
		jsp = "responseEmployee";
		title = "Employee";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/** Method to populate Employee list based on employee category based on hospital
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public void populateEmployeeByCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int employeeCategoryId = Integer.parseInt(request.getParameter("Val"));
		int seviceCenterrId=0;
		if(null !=request.getParameter("seviceCenterrId") && request.getParameter("seviceCenterrId")!="0")
		seviceCenterrId = Integer.parseInt(request.getParameter("seviceCenterrId"));
		
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int hospitalId = 0;
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
				&& !(session.getAttribute(RequestConstants.HOSPITAL_ID)
						.equals(""))) {
			hospitalId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("hospitalId", hospitalId);
		detailsMap.put("seviceCenterrId", seviceCenterrId);
		
		map = generalMasterHandlerService.populateEmployeeByCategory(employeeCategoryId,detailsMap);
		
		List<MasEmployee> employeeByCategoryList = new ArrayList<MasEmployee>();
		
		if(null !=map.get("employeeByCategoryList")){
			employeeByCategoryList=(List<MasEmployee>)map.get("employeeByCategoryList");
			
		}

		StringBuffer sb = new StringBuffer();
		
		if(null !=employeeByCategoryList && employeeByCategoryList.size()>0){
			
		for (MasEmployee employee : employeeByCategoryList) {
			sb.append("<item>");
			sb.append("<employeeId>" + employee.getId()
					+ "</employeeId>");
			sb.append("<empName>" + employee.getEmployeeName()
					+ "</empName>");
			sb.append("</item>");
		}
		}
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	
	response.getWriter().close();

			
	}
	
	// -------------------------------- AccountSchedule
	// ------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showAccountScheduleJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String title="";
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) generalMasterHandlerService.showAccountSchedule();
		String jsp = "fa_account_schedule";
		jsp += ".jsp";
		title = "Account Schedule";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAccountSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasAccountSchedule masAccountSchedule = new MasAccountSchedule();
		int postcodeId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		Box box = HMSUtil.getBox(request);
		String scheduleNo = "";
		int orderNo=0;
		int code=0;
		String name="";
		String currentTime="";
		String title="";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		try {
			if (request.getParameter(CODE) != null) {
				code = Integer.parseInt(request.getParameter(CODE));
				box.put("codeS", code);
			}
			/*if (request.getParameter(CODE) != null
					&& !"".equals(request.getParameter(CODE).toString())) {
				code = Integer.parseInt(request
						.getParameter("CODE"));
			}*/
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
				box.put("nameS", name);
			}
			if (request.getParameter("orderNo") != null
					&& !(request.getParameter("orderNo").equals("0"))) {
				orderNo = Integer.parseInt(request
						.getParameter("orderNo"));
			}
			if (request.getParameter(HOSPITAL_ID) != null
					&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
				hospitalId = Integer
						.parseInt(request.getParameter(HOSPITAL_ID));
			}

			if (request.getParameter("scheduleNo") != null) {
				scheduleNo = request.getParameter("scheduleNo");
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


			generalMap.put("code",code);
			generalMap.put("name",name);

			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("scheduleNo", scheduleNo);
			generalMap.put("orderNo", orderNo);
			generalMap.put("userId", userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			List<MasAccountSchedule> existingMasAccountScheduleList = new ArrayList<MasAccountSchedule>();
			existingMasAccountScheduleList = generalMasterHandlerService.checkExistingAccountSchedule(box);
			boolean successfullyAdded = false;

			if (existingMasAccountScheduleList.size() == 0) {
				
				masAccountSchedule.setScheduleCode(code);
				masAccountSchedule.setScheduleName(name);
				masAccountSchedule.setOrderNo(orderNo);
				masAccountSchedule.setScheduleNo(scheduleNo);
				Users users = new Users();
				users.setId(userId);
				masAccountSchedule.setLastChgBy(users);

				masAccountSchedule.setStatus("Y");
				masAccountSchedule.setLastChgDate(currentDate);
				masAccountSchedule.setLastChgTime(currentTime);
				
				successfullyAdded = generalMasterHandlerService.addAccountSchedule(masAccountSchedule);
				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			
			} else {
				message = "Record already exists.";
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
		try {
			map = generalMasterHandlerService.showAccountSchedule();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsp = "fa_account_schedule";
		title = " Add Account Schedule";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAccountSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int scheduleCode = 0;
		String scheduleName = "";
		int orderNo = 0;
		String scheduleNo="";
		int scheduleId = 0;
		Date changedDate = null;
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");
		int hospitalId = 0;

		try {
			if (request.getParameter("orderNo") != null
					&& !(request.getParameter("orderNo").equals("0"))) {
				orderNo = Integer.parseInt(request
						.getParameter("orderNo"));
			}
			if (request.getParameter(HOSPITAL_ID) != null
					&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
				hospitalId = Integer
						.parseInt(request.getParameter(HOSPITAL_ID));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				scheduleId = Integer.parseInt(request.getParameter(COMMON_ID));
			}

			if (request.getParameter("scheduleNo") != null
					&& !(request.getParameter("scheduleNo").equals(""))) {
				scheduleNo =request.getParameter("scheduleNo");
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				scheduleCode =  Integer.parseInt(request.getParameter(CODE));
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				scheduleName = request.getParameter(SEARCH_NAME);
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

			generalMap.put("id", scheduleId);
			generalMap.put("scheduleCode", scheduleCode);
			generalMap.put("name", scheduleName);
			generalMap.put("scheduleNo", scheduleNo);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("orderNo", orderNo);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			Map<String, Object> listMap = new HashMap<String, Object>();

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);

			listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
			List existingScheduleNameList = (List) listMap
					.get("duplicateMastersList");
			boolean dataUpdated = false;

			if (existingScheduleNameList.size() == 0) {
				dataUpdated = generalMasterHandlerService.editAccountSchedule(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingScheduleNameList.size() > 0) {
				message = "Name already exists.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			map = generalMasterHandlerService.showAccountSchedule();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsp = "fa_account_schedule";
		title = " Edit Account Schedule";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchAccountSchedule(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		int scheduleCode = 0;
		String scheduleName = null;
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
			scheduleCode = Integer.parseInt(searchField);
			log.info(Integer.parseInt(searchField));
			scheduleName = null;

		} else {
			scheduleCode = 0;
			scheduleName = searchField;
		}

		map = generalMasterHandlerService.searchAccountSchedule(scheduleCode,scheduleName);

		jsp = "fa_account_schedule";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("scheduleCode",scheduleCode+"");
		map.put("scheduleName", scheduleName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAccountSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int scheduleId = 0;
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
			scheduleId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = generalMasterHandlerService.deleteAccountSchedule(scheduleId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showAccountScheduleJsp";
		try {
			map = generalMasterHandlerService.showAccountSchedule();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "fa_account_schedule";
		title = "delete AccountSchedule";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView generateReportForGeneralMastersInt(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		int hospitalId = 0;
		String hospitalName = "";
		String qry = "";
		String searchField = "";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			mapForDs.put("hospitalId", hospitalId);
			mapResponse = generalMasterHandlerService.getHospitalName(mapForDs);
		}
		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
		}

		String colCode = "";
		if (request.getParameter("colCode") != null
				&& !(request.getParameter("colCode").equals(""))) {
			colCode = request.getParameter("colCode");
		}
		String colName = "";
		if (request.getParameter("colName") != null
				&& !(request.getParameter("colName").equals(""))) {
			colName = request.getParameter("colName");
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
		log.info("searchRadio---" + searchRadio);
		if (searchRadio == 1) {

			if (!searchField.equals("")) {
				qry = "where "+colCode+"="+searchField;
			} else {
				qry = "";
			}
		} else if (searchRadio == 2) {
			if (!searchField.equals("")) {
				qry = "where upper(" + colName + ") like upper('%"
						+ searchField + "%')";
			} else {
				qry = "";
			}
		} else {
			qry = "";
		}

		String jasper = null;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("qry", qry);
		parameters.put("hospitalName", hospitalName);
		parameters.put("hospitalId", hospitalId);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/reports/"));

		Map<String, Object> connectionMap = generalMasterHandlerService
				.getConnection();

		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());

		return null;
	}

	
	// -------------------------------- Lsg
			// ------------------------------------------

			@SuppressWarnings("unchecked")
			public ModelAndView showLsgJsp(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				map = (Map) generalMasterHandlerService.showLsg();
				String jsp = "lsg";
				jsp += ".jsp";
				title = "village";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unchecked")
			public ModelAndView addLsg(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				MasLsg masLsg = new MasLsg();
				int lsgTypeId = 0;
				int hospitalId = 0;
				HttpSession session = request.getSession();
				int userId = (Integer) session.getAttribute("userId");

				int districtId = 0;

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

					if (request.getParameter("districtId") != null
							&& !(request.getParameter("districtId").equals("0"))) {
						districtId = Integer.parseInt(request.getParameter("districtId"));
					}

					if (request.getParameter("lsgTypeId") != null
							&& !(request.getParameter("lsgTypeId").equals("0"))) {
						lsgTypeId = Integer.parseInt(request
								.getParameter("lsgTypeId"));
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
				List lsgTypeCodeList = new ArrayList();
				List lsgTypeNameList = new ArrayList();
				if (listMap.get("duplicateGeneralCodeList") != null) {
					lsgTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
				}
				if (listMap.get("duplicateGeneralNameList") != null) {
					lsgTypeNameList = (List) listMap.get("duplicateGeneralNameList");
				}
				boolean successfullyAdded = false;

				if ((lsgTypeCodeList.size() == 0 || lsgTypeCodeList == null)
						&& (lsgTypeNameList.size() == 0 || lsgTypeNameList == null)) {
					masLsg.setLsgTypeCode(code);
					masLsg.setLsgTypeName(name);

					
					  MasLsgType lsgType = new MasLsgType();
					  lsgType.setId(lsgTypeId);
					  masLsg.setLsgType(lsgType);
					 

					Users users = new Users();
					users.setId(userId);
					masLsg.setLastChgBy(users);

					
				
					MasDistrict district = new MasDistrict();
					district.setId(districtId);
					masLsg.setDistrict(district);
					masLsg.setStatus("Y");
					masLsg.setLastChgDate(currentDate);
					masLsg.setLastChgTime(currentTime);
					successfullyAdded = generalMasterHandlerService
							.addLsg(masLsg);

					if (successfullyAdded) {
						message = "Record Added Successfully !!";
					} else {
						message = "Try Again !!";
					}

				} else if ((lsgTypeCodeList.size() != 0 || lsgTypeCodeList != null)
						|| (lsgTypeNameList.size() != 0) || lsgTypeNameList != null) {
					if ((lsgTypeCodeList.size() != 0 || lsgTypeCodeList != null)
							&& (lsgTypeNameList.size() == 0 || lsgTypeNameList == null)) {
						message = "Lsg Code already exists.";
					} else if ((lsgTypeNameList.size() != 0 || lsgTypeNameList != null)
							&& (lsgTypeCodeList.size() == 0 || lsgTypeCodeList == null)) {
						message = "Lsg Name already exists.";
					} else if ((lsgTypeCodeList.size() != 0 || lsgTypeCodeList != null)
							&& (lsgTypeCodeList.size() != 0 || lsgTypeNameList != null)) {
						message = "Lsg Code and Name exist.";
					}
				}
				try {
					map = generalMasterHandlerService.showLsg();

				} catch (Exception e) {
					e.printStackTrace();
				}
				// jsp="lsg"_JSP;
				// title="Add Lsg";
				// jsp += ".jsp";

				String jsp = "lsg";
				title = " Add village";
				jsp += ".jsp";

				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView editLsg(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();

				HttpSession session = request.getSession();
				String lsgTypeCode = "";
				String lsgTypeName = "";
				int lsgTypeId = 0;
				int districtId = 0;
				int lsgId = 0;
				Date changedDate = null;
				@SuppressWarnings("unused")
				String changedTime = "";
				Integer userId = (Integer) session.getAttribute("userId");
				int hospitalId = 0;

				try {
					if (request.getParameter("lsgTypeId") != null
							&& !(request.getParameter("lsgTypeId").equals("0"))) {
						lsgTypeId = Integer.parseInt(request
								.getParameter("lsgTypeId"));
					}
					if (request.getParameter(HOSPITAL_ID) != null
							&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
						hospitalId = Integer
								.parseInt(request.getParameter(HOSPITAL_ID));
					}
					if (request.getParameter(COMMON_ID) != null
							&& !(request.getParameter(COMMON_ID).equals(""))) {
						lsgId = Integer.parseInt(request.getParameter(COMMON_ID));
					}

					if (request.getParameter("districtId") != null
							&& !(request.getParameter("districtId").equals("0"))) {
						districtId = Integer.parseInt(request.getParameter("districtId"));
					}
					if (request.getParameter(CODE) != null
							&& !(request.getParameter(CODE).equals(""))) {
						lsgTypeCode = request.getParameter(CODE);
					}
					if (request.getParameter(SEARCH_NAME) != null
							&& !(request.getParameter(SEARCH_NAME).equals(""))) {
						lsgTypeName = request.getParameter(SEARCH_NAME);
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

					generalMap.put("id", lsgId);
					generalMap.put("lsgTypeCode", lsgTypeCode);
					generalMap.put("name", lsgTypeName);
					generalMap.put("lsgTypeId", lsgTypeId);
					generalMap.put("hospitalId", hospitalId);
					generalMap.put("districtId", districtId);
					generalMap.put("currentDate", changedDate);
					generalMap.put("currentTime", changedTime);
					generalMap.put("userId", userId);
					Map<String, Object> listMap = new HashMap<String, Object>();

					generalMap.put("pojoPropertyName", pojoPropertyName);
					generalMap.put("pojoName", pojoName);
					generalMap.put("flag", true);

					listMap = commonMasterHandlerService
							.checkForExistingMasters(generalMap);
					List existingLsgTypeNameList = (List) listMap
							.get("duplicateMastersList");
					boolean dataUpdated = false;

					if (existingLsgTypeNameList.size() == 0) {
						dataUpdated = generalMasterHandlerService
								.editLsg(generalMap);

						if (dataUpdated == true) {
							message = "Data updated Successfully !!";
						} else {
							message = "Data Cant Be Updated !!";
						}
					} else if (existingLsgTypeNameList.size() > 0) {
						message = "Name already exists.";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					map = generalMasterHandlerService.showLsg();

				} catch (Exception e) {
					e.printStackTrace();
				}
				// jsp="lsg"_JSP;
				// title="Edit Lsg";
				// jsp += ".jsp";

				String jsp = "lsg";
				title = " Edit village";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);

			}

			public ModelAndView searchLsg(HttpServletRequest request,
					HttpServletResponse response) throws ServletRequestBindingException {
				Map<String, Object> map = new HashMap<String, Object>();
				String searchField = null;
				String lsgTypeCode = null;
				String lsgTypeName = null;
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
					lsgTypeCode = searchField;
					lsgTypeName = null;

				} else {
					lsgTypeCode = null;
					lsgTypeName = searchField;
				}

				//

				map = generalMasterHandlerService.searchLsg(lsgTypeCode,
						lsgTypeName);

				jsp = "lsg";

				jsp += ".jsp";
				map.put("search", "search");
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("lsgTypeCode", lsgTypeCode);
				map.put("lsgTypeName", lsgTypeName);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView deleteLsg(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int lsgId = 0;
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
					lsgId = Integer.parseInt(request.getParameter(COMMON_ID));
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
				dataDeleted = generalMasterHandlerService.deleteLsg(lsgId,generalMap);
				if (dataDeleted == true) {
					message = "Record is InActivated successfully !!";
				}

				else {
					message = "Record is Activated successfully !!";
				}
				url = "/hms/hms/generalMaster?method=showLsgJsp";
				try {
					map = generalMasterHandlerService.showLsg();

				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "lsg";
				title = "delete Lsg";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}
			
			
			@SuppressWarnings("unchecked")
			public ModelAndView showMasterJsp(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				map = (Map) generalMasterHandlerService.showMaster();
				String jsp = "ph_master";
				jsp += ".jsp";
				title = "master";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unchecked")
			public ModelAndView addMaster(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				PhMaster phMaster = new PhMaster();
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
				List masterCodeList = new ArrayList();
				List masterNameList = new ArrayList();
				if (listMap.get("duplicateGeneralCodeList") != null) {
					masterCodeList = (List) listMap.get("duplicateGeneralCodeList");
				}
				if (listMap.get("duplicateGeneralNameList") != null) {
					masterNameList = (List) listMap.get("duplicateGeneralNameList");
				}
				boolean successfullyAdded = false;

				if ((masterCodeList.size() == 0 || masterCodeList == null)
						&& (masterNameList.size() == 0 || masterNameList == null)) {
					phMaster.setMasterCode(code);
					phMaster.setMasterName(name);


					Users users = new Users();
					users.setId(userId);
					phMaster.setLastChgBy(users);

					phMaster.setStatus("Y");
					phMaster.setLastChgDate(currentDate);
					phMaster.setLastChgTime(currentTime);
					successfullyAdded = generalMasterHandlerService.addMaster(phMaster);

					if (successfullyAdded) {
						message = "Record Added Successfully !!";
					} else {
						message = "Try Again !!";
					}

				} else if ((masterCodeList.size() != 0 || masterCodeList != null)
						|| (masterNameList.size() != 0) || masterNameList != null) {
					if ((masterCodeList.size() != 0 || masterCodeList != null)
							&& (masterNameList.size() == 0 || masterNameList == null)) {
						message = "Master Code already exists.";
					} else if ((masterNameList.size() != 0 || masterNameList != null)
							&& (masterCodeList.size() == 0 || masterCodeList == null)) {
						message = "Master Name already exists.";
					} else if ((masterCodeList.size() != 0 || masterCodeList != null)
							&& (masterCodeList.size() != 0 || masterNameList != null)) {
						message = "Master Code and Name exist.";
					}
				}
				try {
					map = generalMasterHandlerService.showMaster();

				} catch (Exception e) {
					e.printStackTrace();
				}

				String jsp = "ph_master";
				title = " Add master";
				jsp += ".jsp";

				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView editMaster(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();

				HttpSession session = request.getSession();
				String masterCode = "";
				String masterName = "";
				int masterId = 0;
				Date changedDate = null;
				@SuppressWarnings("unused")
				String changedTime = "";
				Integer userId = (Integer) session.getAttribute("userId");

				try {
					
					if (request.getParameter(COMMON_ID) != null
							&& !(request.getParameter(COMMON_ID).equals(""))) {
						masterId = Integer.parseInt(request.getParameter(COMMON_ID));
					}

				
					if (request.getParameter(CODE) != null
							&& !(request.getParameter(CODE).equals(""))) {
						masterCode = request.getParameter(CODE);
					}
					
					if (request.getParameter(SEARCH_NAME) != null
							&& !(request.getParameter(CODE).equals(""))) {
						masterName = request.getParameter(SEARCH_NAME);
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

					generalMap.put("id", masterId);
					generalMap.put("masterCode", masterCode);
					generalMap.put("name", masterName);
				
					generalMap.put("currentDate", changedDate);
					generalMap.put("currentTime", changedTime);
					generalMap.put("userId", userId);
					Map<String, Object> listMap = new HashMap<String, Object>();

					generalMap.put("pojoPropertyName", pojoPropertyName);
					generalMap.put("pojoName", pojoName);
					generalMap.put("flag", true);

					listMap = commonMasterHandlerService
							.checkForExistingMasters(generalMap);
					List existingMasterNameList = (List) listMap
							.get("duplicateMastersList");
					boolean dataUpdated = false;

					if (existingMasterNameList.size() == 0) {
						dataUpdated = generalMasterHandlerService
								.editMaster(generalMap);

						if (dataUpdated == true) {
							message = "Data updated Successfully !!";
						} else {
							message = "Data Cant Be Updated !!";
						}
					} else if (existingMasterNameList.size() > 0) {
						message = "Name already exists.";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					map = generalMasterHandlerService.showMaster();

				} catch (Exception e) {
					e.printStackTrace();
				}
				// jsp="ph_master"_JSP;
				// title="Edit Master";
				// jsp += ".jsp";

				String jsp = "ph_master";
				title = " Edit master";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);

			}

			public ModelAndView searchMaster(HttpServletRequest request,
					HttpServletResponse response) throws ServletRequestBindingException {
				Map<String, Object> map = new HashMap<String, Object>();
				String searchField = null;
				String masterCode = null;
				String masterName = null;
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
					masterCode = searchField;
					masterName = null;

				} else {
					masterCode = null;
					masterName = searchField;
				}

				//

				map = generalMasterHandlerService.searchMaster(masterCode,
						masterName);

				jsp = "ph_master";

				jsp += ".jsp";
				map.put("search", "search");
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("masterCode", masterCode);
				map.put("masterName", masterName);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView deleteMaster(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int masterId = 0;
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
					masterId = Integer.parseInt(request.getParameter(COMMON_ID));
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
				dataDeleted = generalMasterHandlerService.deleteMaster(masterId,
						generalMap);
				if (dataDeleted == true) {
					message = "Record is InActivated successfully !!";
				}

				else {
					message = "Record is Activated successfully !!";
				}
				url = "/hms/hms/generalMaster?method=showMasterJsp";
				try {
					map = generalMasterHandlerService.showMaster();

				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "ph_master";
				title = "delete Master";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			

			@SuppressWarnings("unchecked")
			public ModelAndView showPhMasterDataJsp(HttpServletRequest request,
					HttpServletResponse response) {
				session = request.getSession();
				map = generalMasterHandlerService.showPhMasterDataJsp();
				jsp = "ph_master_data";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unchecked")
			public ModelAndView searchPhMasterData(HttpServletRequest request,
					HttpServletResponse response) throws ServletRequestBindingException {
				Map<String, Object> map = new HashMap<String, Object>();
				String phMasterDataName = null;
				String searchField = null;

				
			
				
				try {
					if (request.getParameter(SEARCH_FIELD) != null
							&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
						searchField = request.getParameter(SEARCH_FIELD);
					}

					
					
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				phMasterDataName = searchField;
				
				map = generalMasterHandlerService.searchPhMasterData(phMasterDataName);

				jsp = "ph_master_data";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("search", "search");
				map.put("phMasterDataName", phMasterDataName);
				
				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unchecked")
			public ModelAndView addPhMasterData(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				PhMasterData phMasterData = new PhMasterData();
				int masterId = 0;
				
				int userId = 0;
				Map<String, Object> listMap = new HashMap<String, Object>();
				Map<String, Object> listMap1 = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				Date currentDate = new Date();
				HttpSession session = request.getSession();
				String userName = "";
				userName = (String) session.getAttribute("userName");
				String lastChangedDate = "";
				String lastChangedTime = "";
				listMap1 = HMSUtil.getCurrentDateAndTime();
				lastChangedTime = (String) listMap1.get("currentTime");
				lastChangedDate = (String) listMap1.get("currentDate");

				
				if (request.getParameter(SEARCH_NAME) != null) {
					name = request.getParameter(SEARCH_NAME);

				}

				if (request.getParameter("masterId") != null
						&& !request.getParameter("masterId").equals("0")) {
					masterId = Integer.parseInt(request.getParameter("masterId"));
				}

				currentDate = HMSUtil.convertStringTypeDateToDateType(lastChangedDate);

				currentTime = lastChangedTime;

				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}

				
				if (session.getAttribute("userId") != null)
					userId = Integer.parseInt("" + session.getAttribute("userId"));
				generalMap.put("userId", userId);
				generalMap.put("name", name);
				generalMap.put("masterId", masterId);
				generalMap.put("currentDate", currentDate);
				generalMap.put("currentTime", currentTime);
				
				listMap = generalMasterHandlerService.existRecord(generalMap);

				
				List existRecordList = new ArrayList();

				if (listMap.get("existRecordList") != null) {
					existRecordList = (List) listMap
							.get("existRecordList");
				}
				log.info(existRecordList.size()+"existRecordListexistRecordListexistRecordList");
				boolean successfullyAdded = false;

				if (existRecordList.size() == 0 || existRecordList == null) {
					
					phMasterData.setDataName(name);

					if (masterId != 0) {
						PhMaster phMaster = new PhMaster();
						phMaster.setId(masterId);
						phMasterData.setMaster(phMaster);
					}
					phMasterData.setStatus("Y");
					
					Users users = new Users();
					users.setId(userId);
					phMasterData.setLastChgBy(users);
					phMasterData.setMasterType("RT");
					phMasterData.setLastChgDate(currentDate);
					phMasterData.setLastChgTime(currentTime);
					successfullyAdded = generalMasterHandlerService.addPhMasterData(phMasterData,masterId);

					if (successfullyAdded) {
						message = "Record Added Successfully !!";
					} else {
						message = "Try Again !!";

					}
				}

				else{
						message = "Master Type and Name already exist.";					
				}
				url = "/hms/hms/generalMaster?method=showPhMasterDataJsp";
				try {
					map = generalMasterHandlerService.showPhMasterDataJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "ph_master_data";
				title = "Add Master Data";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView editPhMasterData(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> listMap1 = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				session = request.getSession();
				int dataId=0;
				String dataName = "";
				int masterId = 0;
				Map<String, Object> listMap = new HashMap<String, Object>();
				Date changedDate = null;
				String changedTime = "";
				int userId=0;
				userName = (String) session.getAttribute("userName");
				String lastChangedDate = "";
				String lastChangedTime = "";
				listMap1 = HMSUtil.getCurrentDateAndTime();
				lastChangedTime = (String) listMap1.get("currentTime");
				lastChangedDate = (String) listMap1.get("currentDate");
				if (request.getParameter("masterId") != null
						&& !(request.getParameter("masterId").equals("0"))) {
					masterId = Integer.parseInt(request.getParameter("masterId"));
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals("0"))) {
					dataId = Integer.parseInt(request.getParameter(COMMON_ID));
				}
				
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					dataName = request.getParameter(SEARCH_NAME);
				}

				if (session.getAttribute("userId") != null)
					userId = Integer.parseInt("" + session.getAttribute("userId"));
				generalMap.put("userId", userId);
				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}

				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				generalMap.put("id", dataId);
				generalMap.put("name", dataName);
				generalMap.put("masterId", masterId);
				generalMap.put("currentDate",HMSUtil.convertStringTypeDateToDateType(lastChangedDate));
				generalMap.put("currentTime", lastChangedTime);

				boolean dataUpdated = false;

				listMap = generalMasterHandlerService.existRecord(generalMap);

				
				List existRecordList = new ArrayList();

				if (listMap.get("existRecordList") != null) {
					existRecordList = (List) listMap.get("existRecordList");
				}
				log.info(existRecordList.size()+"existRecordListexistRecordListexistRecordList");
				boolean successfullyAdded = false;

				if (existRecordList.size() == 0 || existRecordList == null) {
					
				
				dataUpdated = generalMasterHandlerService.editPhMasterData(generalMap);

				if (dataUpdated == true) {
					message = "Record Updated Successfully !!";

				} else {
					message = "Record Cant be updated !!";
				}
				}
				else{
					message = "Master Type and Name already exist.";					
				}
				url = "/hms/hms/generalMaster?method=showPhMasterDataJsp";
				try {
					map = generalMasterHandlerService.showPhMasterDataJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				jsp = "ph_master_data";
				
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView deletePhMasterData(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> listMap1 = new HashMap<String, Object>();

				int dataId = 0;
				String message = null;
				String changedTime = "";
				Date changedDate = null;
				Map<String, Object> generalMap = new HashMap<String, Object>();
				String userName = "";
				int userId=0;
				userName = (String) session.getAttribute("userName");
				String lastChangedDate = "";
				String lastChangedTime = "";
				listMap1 = HMSUtil.getCurrentDateAndTime();
				lastChangedTime = (String) listMap1.get("currentTime");
				lastChangedDate = (String) listMap1.get("currentDate");
				String flag = "";
				if (request.getParameter("flag") != null) {
					flag = request.getParameter("flag");
					generalMap.put("flag", flag);
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					dataId = Integer.parseInt(request.getParameter(COMMON_ID));
				}
				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}

				changedDate = new Date();
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
				if (session.getAttribute("userId") != null)
					userId = Integer.parseInt("" + session.getAttribute("userId"));
				generalMap.put("userId", userId);
				generalMap.put("currentDate", HMSUtil.convertStringTypeDateToDateType(lastChangedDate));
				generalMap.put("currentTime", lastChangedTime);
				boolean dataDeleted = false;
				dataDeleted = generalMasterHandlerService.deletePhMasterData(dataId, generalMap);
				if (dataDeleted == true) {
					message = "Record is InActivated successfully !!";
				}

				else {
					message = "Record is Activated successfully !!";
				}
				url = "/hms/hms/generalMaster?method=showPhMasterDataJsp";
				try {
					map = generalMasterHandlerService.showPhMasterDataJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				jsp = "ph_master_data";
				
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}
			
			//govind code 11-7-2016
			public void populateLsgByDistrictId(HttpServletRequest request,
					HttpServletResponse response) throws IOException{
				
				Map<String, Object> detailsMap = new HashMap<String, Object>();
				
				HttpSession session=request.getSession();
				int hospitalId=0;
				int districtId=0;
				if(null !=request.getParameter("districtId") && !request.getParameter("districtId").equals("")){
					districtId=Integer.parseInt(request.getParameter("districtId"));
				}
				
			
				detailsMap = generalMasterHandlerService.populateLsgByDistrictId(districtId);
				
				
				
				
				List<MasLsg> lsgList=new ArrayList<MasLsg>();
				if(null !=detailsMap.get("lsgList")){
					lsgList=(List<MasLsg>)detailsMap.get("lsgList");
					
				}
				StringBuffer sb = new StringBuffer();
				
				if(null !=lsgList && lsgList.size()>0){
					for (MasLsg lsg : lsgList) {
					sb.append("<item>");
					sb.append("<id>" + lsg.getId() + "</id>");
					sb.append("<name>" + lsg.getLsgTypeName() + "</name>");
					
					sb.append("</item>");
				
					}
				}
				else{
					sb.append("<item>");
					sb.append("<id>" + "" + "</id>");
					sb.append("<name>" + "" + "</name>");
					
					sb.append("</item>");
				}
				
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
			
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
				
				
			
			}
			//govind code end
			
			//govind code 12-7-2016
			public void populateWardByLsgId(HttpServletRequest request,
					HttpServletResponse response) throws IOException{
				
				Map<String, Object> detailsMap = new HashMap<String, Object>();
				
				HttpSession session=request.getSession();
				int hospitalId=0;
				int lsgId=0;
				if(null !=request.getParameter("lsgId") && !request.getParameter("lsgId").equals("")){
					lsgId=Integer.parseInt(request.getParameter("lsgId"));
				}
				
			
				detailsMap = generalMasterHandlerService.populateWardByLsgId(lsgId);
				
				
				
				
				List<MasWard> wardList=new ArrayList<MasWard>();
				if(null !=detailsMap.get("wardList")){
					wardList=(List<MasWard>)detailsMap.get("wardList");
					
				}
				StringBuffer sb = new StringBuffer();
				
				if(null !=wardList && wardList.size()>0){
					for (MasWard lsg : wardList) {
					sb.append("<item>");
					sb.append("<id>" + lsg.getId() + "</id>");
					sb.append("<name>" + lsg.getWardName() + "</name>");
					
					sb.append("</item>");
				
					}
				}
				else{
					sb.append("<item>");
					sb.append("<id>" + "" + "</id>");
					sb.append("<name>" + "" + "</name>");
					
					sb.append("</item>");
				}
				
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
			
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
				
				
			
			}
			//govind code end
			//@SuppressWarnings("unchecked")
			
			//----------------------------------- Heading Master ---------------------------
			
			public ModelAndView showHeadingJsp(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				map = (Map) generalMasterHandlerService.showHeadingJsp();
				String jsp = "sp_heading";
				jsp += ".jsp";
				title = "Headin";
				map.put("contentJsp", jsp);
				map.put("pageNo", 1);
				map.put("title", title);
				return new ModelAndView("index", "map", map);

			}

			@SuppressWarnings("unchecked")
			public ModelAndView addHeading(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				MasSpecialityHeading masHeading = new MasSpecialityHeading();
				HttpSession session = request.getSession();
				Map<String, Object> listMap = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				Date currentDate = new Date();
				Integer userId = (Integer) session.getAttribute("userId");
				String display = "";
				String headingThree = "";
				String headingFour= "";
				String commonHeading= "";

				try {
					if (session.getAttribute("userId") != null) {
						userId = (Integer) session.getAttribute("userId");

					}

					if (request.getParameter(CODE) != null
							&& !"".equals(request.getParameter(CODE))) {
						code = request.getParameter(CODE);
						log.info("CODE" + request.getParameter(CODE));
					}
					if (request.getParameter(SEARCH_NAME) != null && !"".equals(request.getParameter(SEARCH_NAME))) {
						name = request.getParameter(SEARCH_NAME);
					}
					
					/*if (request.getParameter("headingThree") != null && !"".equals(request.getParameter("headingThree"))) {
						headingThree = request.getParameter("headingThree");
					}
					
					
					if (request.getParameter("headingFour") != null && !"".equals(request.getParameter("headingFour"))) {
						headingFour = request.getParameter("headingFour");
					}*/
					
					
				if (request.getParameter("commonHeading") != null && !"".equals(request.getParameter("commonHeading"))) {
						commonHeading = request.getParameter("commonHeading");
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
					generalMap.put("userId", userId);
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

				List headingCodeList = new ArrayList();
				List headingNameList = new ArrayList();

				if (listMap.get("duplicateGeneralCodeList") != null) {
					headingCodeList = (List) listMap.get("duplicateGeneralCodeList");

				}
				if (listMap.get("duplicateGeneralNameList") != null) {
					headingNameList = (List) listMap.get("duplicateGeneralNameList");

				}
				boolean successfullyAdded = false;

				if ((headingCodeList.size() == 0 || headingCodeList == null)
						&& (headingNameList.size() == 0 || headingNameList == null)) {

					masHeading.setSpHeadingOne(code);
					masHeading.setSpHeadingTwo(name);
					/*masHeading.setSpHeadingThree(headingThree);
					masHeading.setSpHeadingThree(headingFour);*/
					masHeading.setSpCommonHeading(commonHeading);

					masHeading.setStatus("Y");
					Users users = new Users();
					users.setId(userId);

					masHeading.setLastChgBy(users);
					masHeading.setLastChgDate(currentDate);
					masHeading.setLastChgTime(currentTime);
					
			
					successfullyAdded = generalMasterHandlerService.addHeading(masHeading);

					if (successfullyAdded) {
						message = "Record Added Successfully !!";
					} else {
						message = "Try Again !!";
					}

				} else if ((headingCodeList.size() != 0 || headingCodeList != null)
						|| (headingNameList.size() != 0) || headingNameList != null) {
					if ((headingCodeList.size() != 0 || headingCodeList != null)
							&& (headingNameList.size() == 0 || headingNameList == null)) {
						message = "Heading One already exists.";
					} else if ((headingNameList.size() != 0 || headingNameList != null)
							&& (headingCodeList.size() == 0 || headingCodeList == null)) {
						message = "Heading Two already exists.";
					} else if ((headingCodeList.size() != 0 || headingCodeList != null)
							&& (headingNameList.size() != 0 || headingNameList != null)) {
						message = "Heading One and Heading Two exist.";
					}
				}

				try {
					map = generalMasterHandlerService.showHeadingJsp();

				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "sp_heading";
				title = "Add Heading";
				jsp += ".jsp";
				// map.put("pageNo",
				// Integer.parseInt(request.getParameter("pageNoEdit")));
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);

			}

			public ModelAndView searchHeading(HttpServletRequest request,
					HttpServletResponse response) throws ServletRequestBindingException {
				Map<String, Object> map = new HashMap<String, Object>();
				String headingOne = null;
				String headingTwo = null;
				String searchField = null;

				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					headingOne = request.getParameter(CODE);
				}

				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					headingTwo = request.getParameter(SEARCH_NAME);
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
					log.info("searchRadio" + searchRadio);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (searchRadio == 1) {
					headingOne = searchField;
					headingTwo = null;
				} else {
					headingOne = null;
					headingTwo = searchField;
				}
				map = generalMasterHandlerService.searchHeading(headingOne, headingTwo);
				jsp = "sp_heading";
				jsp += ".jsp";
				map.put("search", "search");
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("headingOne", headingOne);
				map.put("headingTwo", headingTwo);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView editHeadingToDatabase(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();

				String headingOne = "";
				String headingTwo = "";
				int headingId = 0;
				Date changedDate = null;
				String changedTime = "";
				Date currentDate = null;
				int userId = 0;
				String headingThree = "";
				String headingFour= "";
				String commonHeading= "";

				HttpSession session = request.getSession();

				if (session.getAttribute("userId") != null) {
					userId = (Integer) session.getAttribute("userId");
				}

				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					headingId = Integer.parseInt(request.getParameter(COMMON_ID));
				}
				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					headingOne = request.getParameter(CODE);
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					headingTwo = request.getParameter(SEARCH_NAME);
				}
				
				/*if (request.getParameter("headingThree") != null && !"".equals(request.getParameter("headingThree"))) {
					headingThree = request.getParameter("headingThree");
				}
				
				
				if (request.getParameter("headingFour") != null && !"".equals(request.getParameter("headingFour"))) {
					headingFour = request.getParameter("headingFour");
				}*/
				
				
				if (request.getParameter("commonHeading") != null && !"".equals(request.getParameter("commonHeading"))) {
					commonHeading = request.getParameter("commonHeading");
				}
				
				if (request.getParameter(CHANGED_TIME) != null
						&& !(request.getParameter(CHANGED_TIME).equals(""))) {
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
				generalMap.put("id", headingId);
				generalMap.put("headingOne", headingOne);
				generalMap.put("name", headingTwo);
				//generalMap.put("headingThree", headingThree);
				//generalMap.put("headingFour", headingFour);
				generalMap.put("commonHeading", commonHeading);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("userId", userId);
				Map<String, Object> listMap = new HashMap<String, Object>();
				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);
				generalMap.put("flag", true);
				listMap = commonMasterHandlerService
						.checkForExistingMasters(generalMap);
				List existingBloodHeadingNameList = (List) listMap
						.get("duplicateMastersList");
				boolean dataUpdated = false;

				if (existingBloodHeadingNameList.size() == 0) {
					dataUpdated = generalMasterHandlerService.editHeadingToDatabase(generalMap);

					if (dataUpdated == true) {
						message = "Data updated Successfully !!";
					} else {
						message = "Data Cant Be Updated !!";
					}
				} else if (existingBloodHeadingNameList.size() > 0) {
					message = "Name already exists.";
				}
				url = "/hms/hms/generalMaster?method=showHeadingJsp";
				try {
					map = generalMasterHandlerService.showHeadingJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "sp_heading";
				title = "Update Heading";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView deleteHeading(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				int headingId = 0;
				String message = null;
				String changedTime = "";
				Date changedDate = null;
				String flag = "";
				int userId = 0;
				HttpSession session = request.getSession();

				if (session.getAttribute("userId") != null) {
					userId = (Integer) session.getAttribute("userId");
				}

				if (request.getParameter("flag") != null) {
					flag = request.getParameter("flag");
					generalMap.put("flag", flag);
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					headingId = Integer.parseInt(request.getParameter(COMMON_ID));
				}
				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}

			

				changedDate = new Date();
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("userId", userId);

				boolean dataDeleted = false;
				dataDeleted = generalMasterHandlerService.deleteHeading(headingId, generalMap);
				if (dataDeleted == true) {
					message = "Record is InActivated successfully !!";
				}

				else {
					message = "Record is Activated successfully !!";
				}
				url = "/hms/hms/generalMaster?method=showHeadingJsp";
				try {
					map = generalMasterHandlerService.showHeadingJsp();

				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "sp_heading";
				title = "Delete Heading";
				jsp += ".jsp";

				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);

			}
			@SuppressWarnings("unused")
			public ModelAndView getHospitalListForAutoCompleteItem(
					HttpServletRequest request, HttpServletResponse response) {
		log.info("call getHospitalListForAutoCompleteItem");
				HttpSession session = request.getSession();
				String requiredField = "",requiredField1="",requiredField2="";
				int deptId = 0;
				String autoHint = "";
				int counter=0;
				boolean lastPrescripitionBasedDispensing=false;
				Box box=HMSUtil.getBox(request);
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> map1 = new HashMap<String, Object>();
				String instName=null;
				int districtId=0,instType=0;
				try {
					if (request.getParameter("requiredField") != null) {
						requiredField = request.getParameter("requiredField");
					}
					log.info("requiredField "+requiredField+" requiredField1 "+requiredField1+" requiredField2 "+requiredField2);
					if (request.getParameter(requiredField) != null) {
						instName = request.getParameter(requiredField);
						map1.put("instName",instName);
					}
					if (request.getParameter("districtId") != null) {
						log.info("districtId not null");
						districtId =Integer.parseInt(request.getParameter("districtId"));
						map1.put("districtId",districtId);
					}
					if (request.getParameter("instType") != null) {
						instType = Integer.parseInt(request.getParameter("instType"));
						map1.put("instType",instType);
					}
				log.info("instName "+instName+" districtId "+districtId+" instType "+instType);
					map = generalMasterHandlerService.getHospitalListForAutoCompleteItem(map1);
					List<MasHospital> instituteList = new ArrayList<MasHospital>();
					if(map.get("instituteList") != null){
						instituteList = (List<MasHospital>)map.get("instituteList");
					}

					log.info("instituteList control "+instituteList.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
			//	map1.put("counter", counter);
				jsp = "hospitalListDiv";
		       return new ModelAndView(jsp, "map", map);
			 }
			
			public void getHospitalId(HttpServletRequest request,
					HttpServletResponse response) {
				HttpSession session = request.getSession();
				session = request.getSession();
				String instName=null;
				List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> map1 = new HashMap<String, Object>();
				String variableName="N";
				if (request.getParameter("hospitalName") != null) {
					instName = request.getParameter("hospitalName");
						map1.put("instName",instName);
				
				}
				if (request.getParameter("variable") != null) {
					variableName = request.getParameter("variable");
						map1.put("variableName",variableName);
				
				}
				map = generalMasterHandlerService.getHospitalListForAutoCompleteItem(map1);
				if (map.get("instituteList") != null) {
					masHospitalList = (List) map.get("instituteList");
				}
		log.info("masHospitalList "+masHospitalList.size());
				StringBuffer sb = new StringBuffer();
				try {
					for (MasHospital masHospital : masHospitalList) {
						sb.append("<item>");
						sb.append("<hospitalId>" + masHospital.getId()
								+ "</hospitalId>");
						sb.append("<hospitalName>" + masHospital.getHospitalName()
								+ "</hospitalName>");
						sb.append("</item>");
						
					}

					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");
			
					response.getWriter().write(
							"<?xml version='1.0' encoding='ISO-8859-1'?>");
					response.getWriter().write("<items>");
					response.getWriter().write(sb.toString());
					response.getWriter().write("</items>");
		log.info(sb.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public ModelAndView viewSpecialityTemplate(HttpServletRequest request,HttpServletResponse response) {
				HttpSession session = request.getSession();
				Box box = HMSUtil.getBox(request);
				int template = 0;
				int deptId = 0;
				if (request.getParameter("deptId") != null && !(request.getParameter("deptId").equals(""))) {
					deptId =Integer.parseInt(request.getParameter("deptId"));
					box.put("deptId", deptId);
				}
				if (request.getParameter("tempLate") != null && !(request.getParameter("tempLate").equals(""))) {
					template =Integer.parseInt(request.getParameter("tempLate"));
					box.put("template", template);
				}
				map = generalMasterHandlerService.viewSpecialityTemplate(box);


				jsp = "specilaityTemplatePopup";

				
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);
			}
		public ModelAndView showUserSpecilaityTemplateJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			int hospitalId = 0;
			int sessionUserId = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			}
			
			map = generalMasterHandlerService.showUserSpecilaityTemplateJsp(box);
			jsp = "userSpecialityTemplate.jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

	}
		
		public ModelAndView saveUserSpecialityTemplate(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			int hospitalId = 0;
			int sessionUserId = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
			}
			if (session.getAttribute("userId") != null) {
				sessionUserId = (Integer) session.getAttribute("userId");
			}
			int counter=0;
			log.info("counter===="+request.getParameter("counter"));
			if (request.getParameter("counter") != null
					&& !(request.getParameter("counter").equals(""))) {
				counter= Integer.parseInt(""+request.getParameter("counter"));
				
			}
			int templetCnt=0;
			if (request.getParameter("templetCnt") != null
					&& !(request.getParameter("templetCnt").equals(""))) {
				templetCnt= Integer.parseInt(""+request.getParameter("templetCnt"));
				
			}
			List<Integer> templetIdList=new ArrayList<Integer>();
			List<Integer> userIdList=new ArrayList<Integer>();
			List<Integer> preTempletIdList=new ArrayList<Integer>();
			List<Integer> preUserIdList=new ArrayList<Integer>();
			try {
				if(counter>0){
					for (int ct = 1; ct <=counter; ct++) {
						int empId=0;
						if (request.getParameter("empId"+ct) != null
								&& !(request.getParameter("empId"+ct).equals(""))) {
							empId= Integer.parseInt(""+request.getParameter("empId"+ct));
							
						}
						int userId=0;
						if (request.getParameter("userId"+ct) != null
								&& !(request.getParameter("userId"+ct).equals(""))) {
							userId= Integer.parseInt(""+request.getParameter("userId"+ct));
							
						}
						Vector<String> tempId = box.getVector("templetIdHidden"+ct);
						Vector<String> preTempletIdVec = box.getVector("preTempletId"+ct);
						Vector<String> changeFlagVec = box.getVector("changeFlag"+ct);
						
						for(int templet=0;templet<tempId.size();templet++){
					

							String changeFlag = "";
							if(changeFlagVec.size()>0){
							changeFlag = changeFlagVec.get(templet);
							}
							if(changeFlag.equalsIgnoreCase("yes")){
								int templetId=0;
								
								if(!tempId.get(templet).equals("0") && !tempId.get(templet).equals("") )
									templetId = Integer.parseInt(tempId.get(templet).toString());
								
							
								if(templetId>0){
									templetIdList.add(templetId);
									userIdList.add(userId);
								}
								int preTempletId=0;

								if(!preTempletIdVec.get(templet).equals("") )
									preTempletId = Integer.parseInt(preTempletIdVec.get(templet).toString());
								
								if(preTempletId>0){
									preTempletIdList.add(preTempletId);
									preUserIdList.add(userId);	
								}
							}
						
						}
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			/*
			 * Code for remove rights 
			 */
			Map<String, Object> removeTemplateMap = new HashMap<String, Object>();
			removeTemplateMap.put("preTempletIdList", preTempletIdList);
			removeTemplateMap.put("preUserIdList", preUserIdList);
			removeTemplateMap.put("hospitalId", hospitalId);
			map = generalMasterHandlerService.removeSpecialityTemplateApplicationList(removeTemplateMap);
			/*
			 * Code for remove rights 
			 */
			
			boolean successfullyAdded=true;
			if(templetIdList.size()>0){
				int index=0;
				for (Integer templateIdInt : templetIdList) {
					
					Map<String, Object> mapDetails = new HashMap<String, Object>();
					//mapDetails.put("employeeCategoryId", employeeCategoryId);
					mapDetails.put("templateId", templateIdInt);
			
				    dataMap.put("userName", userName);
					dataMap.put("templateId", templateIdInt);
				
					dataMap.put("hospitalId", hospitalId);
					//dataMap.put("empGroupId", empGroupId);
					dataMap.put("userIdList", userIdList);
					dataMap.put("userId", userIdList.get(index));
					dataMap.put("sessionUserId", sessionUserId);	

					//Map<String, Object> mapTempletOnly = new HashMap<String, Object>();
					map = generalMasterHandlerService.saveUserSpecialityTemplate(dataMap);
					if(map.get("successfullyAdded")!=null){
						successfullyAdded=(Boolean)map.get("successfullyAdded");
					}
					if(!successfullyAdded){
						message="Error Ocurred Please Try Again";
						break;
					}
					++index;
					
				}
			}
			
			if(successfullyAdded){
				message="Template Rights assigned successfully.";
			}
			jsp = "userSpecialityTemplate.jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

	}
		
		public void displayGroupSequence(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				int groupId = 0;
				int templateId = 0;
			try {
				if (request.getParameter("groupId") != null) {
					groupId =Integer.parseInt(request.getParameter("groupId"));
					box.put("groupId", groupId);
				}
				if (request.getParameter("templateId") != null) {
					templateId =Integer.parseInt(request.getParameter("templateId"));
					box.put("templateId", templateId);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			map = generalMasterHandlerService.displayGroupSequence(box);
			List<MasSpecialityDeptGroup> groupSeqList=new ArrayList<MasSpecialityDeptGroup>();
			if (map.get("groupSeqList") != null) {
				groupSeqList = (List<MasSpecialityDeptGroup>) map.get("groupSeqList");
			}
			StringBuffer sb = new StringBuffer();
			try {
				sb.append("<item>");
			
				if(groupSeqList.size()>0){
					sb.append("<grpSeq>" + groupSeqList.get(0).getGroupSeqNo()+ "</grpSeq>");
					
				}
				sb.append("</item>");
				response.setContentType("text/xml");
				response.setHeader("Cache-Control", "no-cache");
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		
		public ModelAndView showLocalityUploadJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			jsp = "localityUpload";
			jsp = jsp + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView importLocality(HttpServletRequest request,
				HttpServletResponse response) {
			Box box = HMSUtil.getBox(request);
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			MultipartFormDataRequest mrequest = null;
			String userName = "";
			String flag1 = "import";
			boolean succesfullyAdded = false;
			String msg = "";

			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				try {
					mrequest = (MultipartFormDataRequest) new MultipartFormDataRequest(
							request);
				} catch (UploadException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			Map<String, Object> uploadFileMap = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			int userId = 0;
			if (session.getAttribute("userId") != null) {
				userId = (Integer) session.getAttribute("userId");
			}
			String uploadURL = getServletContext().getRealPath("/stores/");
			String fileName = box.getString("filename");
			String whiteList = "*.xls";
			List fileUploadedList = null;

			List<String> localityNameList = new ArrayList<String>();
			List<Integer> wardIdList = new ArrayList<Integer>();
			List<Integer> lsgIdList = new ArrayList<Integer>();
			
			box.put("uploadURL", uploadURL);
			box.put("filename", box.getString("filename"));

			try {

				fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL,
						whiteList, box.getString("filename"));
				Boolean fileUploaded = false;
				if (fileUploadedList != null && fileUploadedList.size() != 0) {
					fileUploaded = (Boolean) fileUploadedList.get(0);
				}
				jxl.WorkbookSettings ws = null;
				jxl.Workbook workbook = null;
				jxl.Sheet s = null;
				Cell rowData[] = null;
				int rowCount = '0';
				int columnCount = '0';
				DateCell dc = null;
				int totalSheet = 0;

				try {
					ws = new WorkbookSettings();
					ws.setLocale(new Locale("en", "EN"));
					workbook = jxl.Workbook.getWorkbook(
							(new FileInputStream(box.getString("uploadURL") + "/"
									+ box.getString("filename"))), ws);

					totalSheet = workbook.getNumberOfSheets();

					// Getting Default Sheet i.e. 0
					s = workbook.getSheet(0);

					// Reading Individual Cell
					// Total Total No Of Rows in Sheet, will return you no of rows
					// that are occupied with some data
					rowCount = s.getRows();
					// Total Total No Of Columns in Sheet

					columnCount = s.getColumns();
					String itemCode = "";
					
				log.info("rowCount"+rowCount);

					for (int i = 1; i < rowCount; i++) {
						// Get Individual Row
						rowData = s.getRow(i);
						if (rowData[0].getContents().length() != 0) {

							for (int j = 0; j < columnCount; j++) {
								switch (j) {
								case 0:
									try {
										if (rowData[j].getContents().length() != 0) {
											localityNameList
													.add(rowData[j].getContents());
										} else {
											localityNameList.add("");
										}
									} catch (Exception e) {
										localityNameList.add("");
									}
									break;
								case 1:
									try {
										if (rowData[j].getContents().length() != 0) {
											
											lsgIdList.add(Integer.parseInt(rowData[j].getContents()));
										} else {
											lsgIdList.add(0);
										}
									} catch (Exception e) {
										lsgIdList.add(0);
									}
									break;
								case 2:
									try {
										if (rowData[j].getContents().length() != 0) {
											
											wardIdList.add(Integer.parseInt(rowData[j].getContents()));
										} else {
											wardIdList.add(0);
										}
									} catch (Exception e) {
										wardIdList.add(0);
									}
									break;
						

								}
							}
						}
					}
					workbook.close();
					log.info(localityNameList.size()+"-------------");
					utilMap.put("localityNameList", localityNameList);
					utilMap.put("wardIdList", wardIdList);
					utilMap.put("lsgIdList", lsgIdList);
					
					
					utilMap.put("deptId", deptId);
					utilMap.put("hospitalId", hospitalId);
					utilMap.put("userName", userName);
					utilMap.put("userId", userId);
					box.put("deptId", deptId);
					box.put("userId", userId);
					box.put("hospitalId", hospitalId);
					box.put("numOfRows", 15);
					box.put("pageCount", 10);
					box.put("currPage", 1); 

					map = generalMasterHandlerService.importLocality(utilMap);

				} catch (IOException e) {
					e.printStackTrace();

				}

			} catch (Exception ioe) {
				ioe.printStackTrace();
			}
			jsp = "locality";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);

		}
		
		public void downloadLocality(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			final int BUFFER_SIZE = 4096;
			
			String filePath = "/excel/ph_mas_locality.xls";
			
			ServletContext context =  getServletContext();
			String appPath = context.getRealPath("");
			log.info("appPath = " + appPath);

			String fullPath = appPath + filePath;		
			File downloadFile = new File(fullPath);
			FileInputStream inputStream = new FileInputStream(downloadFile);
			
			String mimeType = context.getMimeType(fullPath);
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			log.info("MIME type: " + mimeType);

			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",
					downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			OutputStream outStream = response.getOutputStream();

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outStream.close();

		}
	
}